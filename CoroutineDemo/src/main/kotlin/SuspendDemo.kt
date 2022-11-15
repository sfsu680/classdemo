import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun  main(args: Array<String>) {
    GlobalScope.launch {
        printWorld()
    }

    println("Hello,")

    Thread.sleep(3000)
}

suspend fun printWorld() {
    delay(1000L)
    println("World!")
}