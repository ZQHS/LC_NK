import java.util.concurrent.CountDownLatch

object ThreadScala {
  private var n: Long = 0L

  @throws[InterruptedException]
  def main(args: Array[String]): Unit = {
    val threads: Array[Thread] = new Array[Thread](100)
    val latch: CountDownLatch = new CountDownLatch(threads.length)
    for (i <- 0 until threads.length) {
      threads(i) = new Thread(() => {
        def foo() = {
          for (j <- 0 until 10000) {
            n += 1
          }
          latch.countDown()
        }

        foo()
      })
    }
    for (i <- 0 until threads.length) {
      threads(i).start()
    }

    latch.await()
    System.out.println(n)
  }
}
