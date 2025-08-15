package kotlin.strings

import java.util.*

fun main() {
    val s= "ab#c"
    val t = "ad#c"
    val result = backspaceCompare(s, t)
    println("result : $result")
}

fun backspaceCompare(s: String, t: String): Boolean {
    val newS = buildStrign(s)
    val newT = buildStrign(t)
    return newT == newS
}

fun buildStrign(str: String): String {
    val stack = LinkedList<Char>()
    for (char in str){
        if (char != '#'){
            stack.addLast(char)
        } else {
            if (stack.isNotEmpty()) stack.removeLast()
        }
    }
    return stack.joinToString("")
}