package lib

import lib.io.Request
import lib.io.Response

class Handler(val routes:HashMap<String, HashMap<String, (Request)->Response>>) {
    //Entry Function
     fun handleRequest(request: String):String {
        val slicedRequest = Helper.splitRequest(request)
        val method = slicedRequest[0]
        val path = slicedRequest[1]
        val protocol = slicedRequest[2]
        val restHeaders:HashMap<String, String> = Helper.processRest(request)
        val content:String = Helper.processContent(slicedRequest)
        return processRequest(method, path, protocol, restHeaders, content)
     }

    fun processRequest(method:String, path:String, protocol:String, restHeaders:HashMap<String, String>, content:String):String{ //TODO:Add option for additional headers
        return if (routes[method]?.get(path) != null) {
            val response = routes[method]?.get(path)?.let { it(Request(header = restHeaders, content = content, method = method, protocol = protocol)) }
            response.toString()
        } else {
            "Route is not set"
        }
    }
}