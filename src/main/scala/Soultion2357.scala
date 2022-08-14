object Soultion2357 {
  def main(args: Array[String]): Unit = {}

  def minimumOperations(nums: Array[Int]): Int = {
    f(nums.filter(_ != 0))
  }

  def f(nums: Array[Int], count: Int = 0): Int = {
    if (nums.isEmpty) {
      count
    } else {
      val min: Int = nums.min
      f(nums.map(_ - min).filter(_ != 0), count + 1)
    }
  }
}
