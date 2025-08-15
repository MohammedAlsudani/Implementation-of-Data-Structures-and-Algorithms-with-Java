package kotlin.array


fun main() {
    val target = 11
    val list = listOf(1,3,7,9,2)
    val result = findPairsOptimal(list,target)
    println("Result: ${result.joinToString(", ")}")
}

// Brute-force	O(n²)
fun findPairs(list: List<Int>, target: Int): Any? {
    if (list.isEmpty()) return null
    for(p1 in list.indices) {
        val numberToFind = target - list[p1]
        for (p2 in list.indices) {
            if (p1 != p2 && list[p2] == numberToFind) {
                return Pair(p1, p2)
            }
        }
    }
    return null
}

fun findPairsBetter(list: List<Int>, target: Int): Any? {
    if (list.isEmpty()) return null
    for (p1 in list.indices){
        val numberToFind = target - list[p1]
        for (p2 in p1 + 1 until list.size) {
            if (list[p2] == numberToFind)
                return Pair(p1,p2)
        }
    }
    return null
}

// Optimal solution O(n)
fun findPairsOptimal(nums: List<Int>, target: Int): IntArray {
    if (nums.isEmpty()) return intArrayOf()
    val seen = mutableMapOf<Int,Int>()
    for ((index, num) in nums.withIndex()){
        val numberToFind = target - num
        if (seen.contains(numberToFind)) {
            return intArrayOf(seen[numberToFind]!!, index)
        }
        seen[num] = index
    }
    return intArrayOf()
}