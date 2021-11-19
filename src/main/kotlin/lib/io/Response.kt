package lib.io

data class Response(val content:String, val status:Int, val headers:HashMap<String, String>, val protocol:String) {
    override fun toString():String {
        var value = ""
        value += protocol
        value += " "
        value += status
        value += "\r\n"
        for (header in headers.keys) {
            value += header
            value += ": "
            value += headers[header]
            value += "\r\n"
        }
        value += "\r\n"
        value += content
        return value
    }
}