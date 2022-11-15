import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//fun main(args: Array<String>) {
//    runBlocking {
//        val job = GlobalScope.launch {
//            delay(1000L)
//            println("World!")
//        }
//
//        println("Hello,")
//        job.join() // wait until child coroutine completes
//        println("Done waiting!")
//    }
//}

fun  main(args: Array<String>) {
    println("start")
    runBlocking {
        val job = GlobalScope.launch {
            delay(1000L)
            println("World!")
        }

        println("Hello,")
        job.join()
        println("Done waiting!")
    }
    println("end")

    Thread.sleep(2000)
}