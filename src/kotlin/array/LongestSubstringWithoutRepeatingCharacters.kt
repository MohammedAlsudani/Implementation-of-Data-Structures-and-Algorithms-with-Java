package kotlin.array


fun main(){
  val text = "abccabb"
  val result = findLengthOFlongestSubstring(text)
    println("result = ${result}")
}

fun findLengthOFlongestSubstring(text: String): Int {
    val seen = mutableMapOf<Char, Int>()
    var left = 0
    var longest = 0
    for (right in text.indices) {
        val currentChar = text[right]
        val previouslySeenChar = seen[currentChar]
        if (previouslySeenChar != null && previouslySeenChar >= left){
            left = previouslySeenChar + 1
        }
        seen[currentChar] = right
        longest = maxOf(longest, right - left +1)
    }
    return longest
}

