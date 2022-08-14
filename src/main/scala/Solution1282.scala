object Solution1282 {
  def groupThePeople(groupSizes: Array[Int]): List[List[Int]] = {
    var list = List.empty[List[Int]]

    groupSizes.zipWithIndex.groupBy(_._1).foreach(x => list = f(x._2, list))

    list
  }

  def f(array: Array[(Int, Int)], list: List[List[Int]]): List[List[Int]] = {
    if (array.isEmpty) {
      list
    } else {
      val add: List[Int] = array.take(array(0)._1).map(_._2).toList
      f(array.takeRight(array.length - array(0)._1), list :+ add)
    }
  }
}
