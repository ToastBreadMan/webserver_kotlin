package lib.io

class Request {
    lateinit var header:HashMap<String, String>
    lateinit var content:String
    lateinit var method: String
    lateinit var protocol:String
}