package kotlin.array

/**
 * Demonstrates how to use Arrays in Kotlin and includes an example algorithm.
 *
 * Arrays in Kotlin:
 * - Fixed size (cannot add/remove elements like a list).
 * - Can store elements of the same type.
 * - Indexed access starting at 0.
 *
 * You can create arrays with:
 * - arrayOf(...)
 * - Array(size) { initializer }
 */
class ArrayExample {

    /**
     * Basic Array usage example
     */
    fun basicArrayUsage() {
        // Create an array of integers
        val numbers = arrayOf(1, 2, 3, 4, 5)

        // Access elements
        println("First element: ${numbers[0]}")
        println("Last element: ${numbers[numbers.size - 1]}")

        // Update an element
        numbers[2] = 99 // changes 3 → 99

        // Iterate over array
        println("Array elements:")
        for (num in numbers) {
            println(num)
        }

        // Using indices to iterate
        println("Array with indices:")
        for (index in numbers.indices) {
            println("Index $index -> ${numbers[index]}")
        }

        // Create array with initializer
        val squares = Array(5) { i -> i * i }
        println("Squares: ${squares.joinToString()}")
    }

    /**
     * Algorithm Example: Find the maximum number in an array.
     * Time Complexity: O(n)
     */
    fun findMax(arr: Array<Int>): Int? {
        if (arr.isEmpty()) return null
        var max = arr[0]
        for (num in arr) {
            if (num > max) max = num
        }
        return max
    }
}

/**
 * Main function to run the examples.
 */
fun main() {
    val example = ArrayExample()

    println("=== Basic Array Usage ===")
    example.basicArrayUsage()

    println("\n=== Find Maximum Number in Array ===")
    val numbers = arrayOf(5, 12, 3, 21, 7)
    val maxValue = example.findMax(numbers)
    println("Max value in array: $maxValue")
}