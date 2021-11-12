package lib

import lib.io.Request
import lib.io.Response

class Handler(val routes:HashMap<String, HashMap<String, (Request)->Response>>) {
    //Entry Function
     fun handleRequest(request: String) {
         val slicedRequest = Helper.splitRequest(request)
         val method = slicedRequest[0]
         val path = slicedRequest[1]
         val protocol = slicedRequest[2] //TODO: add option for additional header info
         val restHeaders:HashMap<String, String> = Helper.processRest(slicedRequest);
        processBaseRequest(method, path, protocol, restHeaders)
     }

    fun processBaseRequest(method:String, path:String, protocol:String, restHeaders:HashMap<String, String>):String{ //TODO:Add option for additional headers
        return if (routes[method]?.get(path) != null) {
            //routes[method]?.get(path)?.let { it(Request()) }.toString()
            "here"
        } else {
            "Route is not set"
        }
    }
}