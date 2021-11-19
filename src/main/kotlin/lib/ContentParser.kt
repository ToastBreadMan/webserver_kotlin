package lib

class ContentParser {
    companion object {
        fun parseForm(content:String):HashMap<String, String>{
            val formContent:HashMap<String,String> = HashMap()
            val blocks = content.split("&")
            for (block in blocks) {
                val keyVal = block.split("=")
                formContent.put(keyVal[0], keyVal[1])
            }
            return formContent
        }
    }
}