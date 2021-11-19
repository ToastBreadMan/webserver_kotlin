import lib.ContentParser
import lib.Helper
import lib.Webserver
import lib.io.Request
import lib.io.Response

fun test(req: Request):Response{
    val headers:HashMap<String, String> = HashMap()
    headers.put("Content-Type", "text/html")
    val resp = Response("<html><form action='/' method='POST'><input name='id' type='text'><input type='submit'></form></html>", 200, headers, req.protocol)
    return resp
}

fun postTest(req:Request):Response{
    /**
    for (header in req.header.keys){
        println(header)
        println(req.header[header])
        println("----------------")
    }
    **/
    println(ContentParser.parseForm(req.content)["id"])
    val headers:HashMap<String, String> = HashMap()
    val resp = Response("worked", 200, headers = headers, req.protocol)
    return resp
}

fun main(){ //Maybe run blocking here
    val webserver = Webserver(8080)
    webserver.add("GET" ,"/", ::test)
    webserver.add("POST", "/", ::postTest)
    webserver.startServer()
}