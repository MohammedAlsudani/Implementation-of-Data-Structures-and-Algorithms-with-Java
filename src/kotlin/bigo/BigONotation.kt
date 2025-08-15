package kotlin.bigo

fun main() {
    val fish = listOf("dory", "bruce", "marlin", "nemo")
    val nemo = listOf("nemo")
    val everyone = listOf("dory", "bruce", "marlin", "nemo", "gill", "bloat", "nigel", "squirt", "darla", "hank")
    val large = List(10000) { "nemo" }
    val listPairs = listOf(1,2,3,4,5)

    findNemo2(large)
    logAllPairsOfArray(listPairs)
}

// O(1) -->> Constant Time
fun compressFirstBox(boxes:Array<Int>){
    println(boxes[0])
}

// O(n) -->> Linear Time
fun findNemo2(fishList: List<String>) {
    val startTime = System.nanoTime()
    fishList.forEach {fish->
        if (fish == "nemo") {
            println("Found NEMO!")
        }
    }
    for (i in fishList.indices){
        if (fishList[i] == "nemo"){
            println(fishList[i])
            break
        }
    }
    val endTime = System.nanoTime()
    val durationMillis = (endTime - startTime) / 1_000_000.0
    println("Call to find Nemo took $durationMillis milliseconds.")
}

// O(n) -->> Linear Time
fun anotherFunChallenge(input: Array<Int>){
    val a =5
    val b = 10
    val c = 50
    for (i in input){
        var x = i + 1
        var y = i + 2
        var z = i + 3
    }
    for (j in input){
        var p = j * 2
        var q = j * 2
    }
    val whoAmI = "I don't know"
}

// O(n) -->> Liner Time
fun compareBoxesTwice(box1:Array<Int>, box2:Array<Int>) {
    for (i in 0 until box1.size){
        println(box1[i])
    }

    for(i in box2.lastIndex downTo 0){
        println(box2[i])
    }
}
// n square (n power of 2)
// O(n^2) -->> Quadratic Time
fun logAllPairsOfArray(list: List<Int>){
    list.forEach {pair1->
        list.forEach { pair2 ->
            println("$pair1 $pair2")
        }
    }
}


// O(n!) -->> factorial(you are adding a loop for every element)
// O(LogN) -->> logarithmic
// O(LogN) -->> logarithmic
// O(NLogN) -->> Linearithmic
// O(2n) -->> Exponential

// which code is best?
// Readable
//            | => speed > space complexity
// Scalable - |
//            | => memory > time complexity
// Memory