package kotlin.hashMap

/**
 * Demonstrates how to use HashMap in Kotlin and an example algorithm.
 *
 * HashMap in Kotlin is a data structure that stores key-value pairs.
 * - Keys are unique.
 * - Average O(1) time for adding, removing, and looking up items.
 *
 * You can use:
 * - mutableMapOf<K, V>() → mutable HashMap
 * - mapOf<K, V>() → immutable map
 */
class HashMapExample {

    /**
     * Basic HashMap usage example
     */
    fun basicHashMapUsage() {
        // Create a mutable HashMap
        val fruits = mutableMapOf<String, Int>()

        // Add items
        fruits["Apple"] = 3
        fruits["Banana"] = 5
        fruits["Mango"] = 10
        fruits["Orange"] = 7

        // Access item
        println("Mango count: ${fruits["Mango"]}") // Output: 10

        // Update item
        fruits["Mango"] = 15

        // Remove item
        fruits.remove("Orange")

        // Check existence
        if ("Mango" in fruits) println("Mango exists")
        if (fruits.containsValue(15)) println("Value 15 exists")

        // Iterate through the map
        println("Fruits in map:")
        for ((key, value) in fruits) {
            println("$key -> $value")
        }
    }

    /**
     * Algorithm Example: Find the first non-repeating character in a string.
     *
     * Why use HashMap here?
     * - Fast lookup for counts (O(1) average).
     * - We can count occurrences in one pass, then find the answer in another.
     */
    fun firstNonRepeatingChar(s: String): Char? {
        val map = HashMap<Char, Int>()

        // Count occurrences
        for (ch in s) {
            map[ch] = map.getOrDefault(ch, 0) + 1
        }

        // Find first char with count 1
        for (ch in s) {
            if (map[ch] == 1) return ch
        }
        return null
    }
}

/**
 * Main function to run the examples.
 */
fun main() {
    val example = HashMapExample()

    println("=== Basic HashMap Usage ===")
    example.basicHashMapUsage()

    println("\n=== First Non-Repeating Character ===")
    val input = "swiss"
    val result = example.firstNonRepeatingChar(input)
    println("First non-repeating char in '$input': $result")
}
