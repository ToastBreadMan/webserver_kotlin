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
                    words.add(word.replace(" ",""))
                }
                //words.add(blockDelim) //TODO:HANDLE WITH CARE
            }
            return words
        }

        fun processRest(splitedRequest: MutableList<String>):HashMap<String,String>{
            val keyValDelim = ":"
            val restRequest: HashMap<String, String> = HashMap()
            for ((i, value) in splitedRequest.iterator().withIndex()){
                if (value.isEmpty()) break
                if (keyValDelim in value) {
                    val splitted = splitedRequest[i].split(keyValDelim)
                    restRequest[splitted[0]] = splitted[1]
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
                if (value.isEmpty()) {
                    add = true
                }
            }
            return content
        }
    }
}