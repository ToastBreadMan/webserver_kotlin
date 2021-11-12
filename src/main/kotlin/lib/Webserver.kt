package lib

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import lib.io.Request
import lib.io.Response
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket

class Webserver(val port: Int) {

    var server:ServerSocket = ServerSocket(port)
    var routes: HashMap<String, HashMap<String, (Request)->Response>> = HashMap()

    fun startServer() = runBlocking {
        println("Webserver started on port $port")
        while (true)
        {
            val client = server.accept()
            launch {    //TODO:Maybe Try coroutines sometimes
                handleClient(client)
            }.join()
        }
    }

    fun add(method:String, path: String, function: (Request)->Response) {
        if (routes[method]?.get(path) == null)
            routes[method]?.set(path, function)
    }

    private fun handleClient(client: Socket){
        PrintWriter(client.getOutputStream(), true).println("Hello")
        val read = BufferedReader(InputStreamReader(client.getInputStream())).readLine()
        println("------BEGIN-------")
        println(read)
        println("-------END--------")
        Handler(routes).handleRequest(read)
        PrintWriter(client.getOutputStream(), true).print("Hello")
        client.close()
        }
    }