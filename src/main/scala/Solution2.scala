object Solution2 {
  def main(args: Array[String]): Unit = {
    println(wordPattern("abba", "dog cat cat dog"))
    println(f("abba".split("")))
    println(f("dog cat cat dog".split(" ")))
  }

  def wordPattern(pattern: String, s: String): Boolean = {
    val strings: Seq[String] = s.split(" ").toList
    val kv1: Map[Char, Int] = pattern.zipWithIndex.toMap
    val kv2: Map[String, Int] = strings.zipWithIndex.toMap

    pattern.map(kv1) == strings.map(kv2)

  }

  def wordPattern2(pattern: String, s: String): Boolean = {
    f(pattern.split("")) == f(s.split(" "))
  }

  def f(arr: Array[String]): List[List[Int]] = {

    val map = scala.collection.mutable.Map.empty[String, List[Int]]
    for (i <- arr.indices) {
      if (map.contains(arr(i))) {
        map(arr(i)) :+= i
      } else {
        map += (arr(i) -> List(i))
      }
    }

    map.toList.map(_._2).sortBy(_.head)
  }
}
