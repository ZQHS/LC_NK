object Solution {
  def commonChars(words: Array[String]): List[String] = {
    if (words.isEmpty) {
      // 如果 words为空，返回空 List
      List()
    } else {
      // 取数组第一个元素作为初始值
      val start: String = words(0)

      // 以第一个元素为初始值，不断往后对比，保留重复的字符串
      val res: String = words.foldLeft(start)((x, y) => {
        same(x, y)
      })

      // 如果结果为 ”“，即输出空 List，若直接输出会输出一个 ”“
      if (res == "") {
        List()
      } else {
        // 分割字符串（默认返回Array)，并转成 List, 返回结果
        res.split("").toList
      }
    }
  }

  /** @param x
    *   进行对比的主体，从头开始往后递归
    * @param y
    *   进行对比的目标
    * @param res
    *   保存重复的字符
    * @return
    *   当x为空时，即对比完成，返回 res
    */
  def same(x: String, y: String, res: String = ""): String = {
    if (x.isEmpty) {
      // 当x为空时，即对比完成，返回 res
      res
    } else {
      // 查找 y中是否包含 x的首个字符
      val index: Int = y.indexOf(x.head)
      if (index == -1) {
        // 如果不包含，则递归对比 x余下的字符串
        same(x.tail, y, res)
      } else {
        // 如果包含，则去掉 y中的这个字符
        val str: String = y.substring(0, index) + y.substring(index + 1)
        // 递归对比 x余下的字符串,和 y去掉当前字符后的字符串，并将当前字符加入到结果 res中
        same(x.tail, str, res + x.head)
      }
    }
  }
}
