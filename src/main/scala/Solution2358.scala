object Solution2358 {
  def maximumGroups(grades: Array[Int]): Int = {
    f(grades.length)

  }

  def f(length: Int, count: Int = 0): Int = {
    if (length <= count) {
      count
    } else {
      f(length - count - 1, count + 1)
    }
  }
}
