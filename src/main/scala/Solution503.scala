import scala.collection.mutable

object Solution503 {
  def nextGreaterElements(nums: Array[Int]): Array[Int] = {
    val n: Int = nums.length
    val stack: mutable.Stack[Int] = mutable.Stack.empty[Int]
    val res: Array[Int] = Array.fill(nums.length)(-1)
    for (i <- 0 until (n * 2)) {
      while (stack.nonEmpty && (nums(stack.head) < nums(i % n))) {
        res(stack.pop()) = nums(i % n)
      }
      stack.push(i % n)
    }
    res
  }

}
