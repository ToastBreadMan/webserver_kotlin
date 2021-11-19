package lib

class Helper {
    companion object {
        fun splitRequest(request: String): MutableList<String>{
            val lineDelim = " "
            val blockDelim = "\n"

            val lines = request.split(blockDelim)
            val words:MutableList<String> = ArrayList()
            for (line in lines){
                val lineWords = line.split(lineDelim)
                for (word in lineWords){
                    //println(word)
                    words.add(word)
                }
                //words.add(blockDelim) //TODO:HANDLE WITH CARE
            }
            return words
        }

        fun processRest(request: String):HashMap<String,String>{
            val keyValDelim = ":"
            val restRequest: HashMap<String, String> = HashMap()
            val lines = request.split("\n")
            for (line in lines){
                if (keyValDelim in line) {
                    val keyVal = line.split(keyValDelim)
                    //println(keyVal[0])
                    restRequest.put(keyVal[0], keyVal[1])
                }
            }
            return restRequest
        }

        fun processContent(splittedRequest:MutableList<String>):String{
            var add = false
            var content = ""
            for ((i, value) in splittedRequest.iterator().withIndex()) {
                if (add) {
                    content = content.plus(value)
                }
                if (value.isBlank()) {
                    add = true
                }
            }
            return content
        }
    }
}