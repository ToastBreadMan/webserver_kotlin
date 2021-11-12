import lib.Helper
import lib.Webserver


fun main(){
    val procString = "GET / HTTP\nContent:text\n\nContent_length:123"
    val request = Helper.splitRequest(procString)
    println(request)
    println("------------")
    val rContent = Helper.processContent(request)
    val rRequest = Helper.processRest(request)
    println(rRequest["Content"])
    //val webserver = Webserver(8080)
    //webserver.startServer()
}