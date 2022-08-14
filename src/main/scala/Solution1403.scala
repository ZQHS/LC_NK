object Solution1403 {
  def minSubsequence(nums: Array[Int]): List[Int] = {
    val sum: Int = nums.sum
    val sorted: Array[Int] = nums.sortBy(-_)

    f(sorted, List(), (sum / 2) + 1)
  }

  def f(array: Array[Int], res: List[Int], sum: Int): List[Int] = {
    if (sum <= 0) {
      res
    } else {
      f(array.tail, res :+ array.head, sum - array.head)
    }
  }
}
