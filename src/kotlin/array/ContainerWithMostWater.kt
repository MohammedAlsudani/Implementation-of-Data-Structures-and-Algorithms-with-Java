package kotlin.array

// area = L * W
fun main() {
    val list = listOf(7,1,2,3,9)
    val result = findMaxArea2(list)
    println("result: $result")
}

// Brutle force
fun findMaxArea(heights: List<Int>): Int {
    var maxArea = 0
    for (startIndex in heights.indices) {
        for (endIndex in startIndex + 1 until heights.size) {
            val height = minOf(heights[startIndex], heights[endIndex])
            val width = endIndex - startIndex
            val currentArea = height * width
            if (currentArea > maxArea){
                maxArea = currentArea
            }
        }
    }
    return maxArea
}

// Optimal Solution
fun findMaxArea2(height: List<Int>): Int {
    var maxArea = 0
    var left = 0
    var right = height.lastIndex
    while (left < right){
        val length = minOf(height[left], height[right])
        val width = right - left
        val currentArea = length * width
        maxArea = maxOf(currentArea, maxArea)
        if (height[left] < height[right]){
            left++
        } else {
            right--
        }
    }
    return maxArea
}


// Optimal Solution
fun findMaxArea3(height: List<Int>): Int {
    var maxArea = 0
    var left = 0
    var right = height.lastIndex
    while (left < right){
        val length = minOf(height[left], height[right])
        val width = right - left
        val currentArea = length * width
        maxArea = maxOf(currentArea, maxArea)
        if (height[left] < height[right]){
            left++
        } else {
            right--
        }
    }
    return maxArea
}

