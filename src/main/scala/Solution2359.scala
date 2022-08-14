object Solution2359 {
  def main(args: Array[String]): Unit = {
    println(closestMeetingNode(Array(2, 2, 3, -1), 0, 1))
  }

  def closestMeetingNode(edges: Array[Int], node1: Int, node2: Int): Int = {
    val length: Int = edges.length
    val arr1: Array[Int] = f(edges, node1)
    val arr2: Array[Int] = f(edges, node2)

    println(arr1.mkString("Array(", ", ", ")"))
    println(arr2.mkString("Array(", ", ", ")"))
    var min = length
    var node = length
    for (i <- edges.indices) {
      val max: Int = math.max(arr1(i), arr2(i))

      if (max < min) {
        min = max
        node = i
      }

    }
    if (min == length) {
      -1
    } else {
      node
    }
  }

  def f(
      edges: Array[Int],
      node: Int
  ): Array[Int] = {
    var index: Int = node
    var count: Int = 0
    val ints: Array[Int] = Array.ofDim[Int](edges.length).map(x => edges.length)
    while (index != -1 && ints(index) == edges.length) {
      ints(index) = count
      count += 1
      index = edges(index)
    }
    ints
  }
}
