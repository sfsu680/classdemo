import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main(args: Array<String>) {

//   for (i in 0..10) {
//      thread {
//         println("hello ${Thread.currentThread().name}")
//         Thread.sleep(1000)
//         println("world ${Thread.currentThread().name}")
//      }
//   }


//   GlobalScope.launch {
//      println("Hello from coroutine")
//      delay(2_000)
//      println("Goodbye from coroutine")
//   }

   for (i in 0..1000) {
      runBlocking {
         println("hello $i ${Thread.currentThread().name}")
         delay(1000)
         println("world $i ${Thread.currentThread().name}")
      }
   }

   Thread.sleep(3000)
}