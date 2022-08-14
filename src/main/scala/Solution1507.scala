object Solution1507 {
  def main(args: Array[String]): Unit = {
    println(reformatDate("5th Oct 2052"))
  }

  def reformatDate(date: String): String = {

    val map: Map[String, String] = Map[String, String](
      "Jan" -> "01",
      "Feb" -> "02",
      "Mar" -> "03",
      "Apr" -> "04",
      "May" -> "05",
      "Jun" -> "06",
      "Jul" -> "07",
      "Aug" -> "08",
      "Sep" -> "09",
      "Oct" -> "10",
      "Nov" -> "11",
      "Dec" -> "12"
    )

    val strings: Array[String] = date.split(" ")
    val year: String = strings(2)
    val month: String = map(strings(1))
    val day: String = strings(0).take(strings(0).length - 2)

    println(String.format("%2s", "5"))

    f"$year-$month-$day%2s"
  }
}
