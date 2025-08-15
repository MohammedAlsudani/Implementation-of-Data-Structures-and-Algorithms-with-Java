package kotlin.array

fun main() {
    val list = listOf(0,1,0,2,1,0,3,1,0,1,2)
    val result = findMaximumContainerOfWater(list)
    println("result: $result")
}

fun findMaximumContainerOfWater(height: List<Int>): Int {
    var totalWater = 0
    for(p in height.indices) {
        var leftP = p
        var rightP = p
        var maxLeft = 0
        var maxRight = 0
        while (leftP >= 0) {
            maxLeft = maxOf(maxLeft, height[leftP])
            leftP--
        }
        while (rightP < height.size){
            maxRight = maxOf(maxRight, height[rightP])
            rightP++
        }
        val currrentWater = minOf(maxLeft,maxRight) - height[p]
        if (currrentWater >= 0){
            totalWater += currrentWater
        }
    }
    return totalWater
}

fun findMaximumContainerOfWater2(height: List<Int>): Int {
    var totalWater = 0
    var maxLeft = 0
    var maxRight = 0
    var left = 0
    var right = height.size - 1
    while (left < right) {
        if (height[left] <= height[right]){
            if (height[left] >= maxLeft){
                maxLeft = height[left]
            } else {
                totalWater += maxLeft - height[left]
            }
            left++
        } else {
            if (height[right] >= maxRight){
                maxRight  = height[right]
            } else{
                totalWater+= maxRight - height[right]
            }
            right--
        }
    }
    return totalWater
}
