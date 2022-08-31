import scala.collection.mutable

object Solution654 {

  def constructMaximumBinaryTree(nums: Array[Int]): TreeNode = {
    val (m, l, r) = g(nums)
    val node = new TreeNode(m)
    f(l, r, node)
    node
  }

  def f(
      left: Array[Int],
      right: Array[Int],
      node: TreeNode
  ): Unit = {
    if (left.nonEmpty) {
      val (m, l, r) = g(left)
      node.left = new TreeNode(m)
      f(l, r, node.left)
    }

    if (right.nonEmpty) {
      val (m, l, r) = g(right)
      node.right = new TreeNode(m)
      f(l, r, node.right)
    }
  }

  def g(nums: Array[Int]): (Int, Array[Int], Array[Int]) = {
    val max: Int = nums.max
    val i: Int = nums.indexOf(max)
    val left: Array[Int] = nums.take(i)
    val right: Array[Int] = nums.takeRight(nums.length - i - 1)
    (max, left, right)
  }

  class TreeNode(
      _value: Int = 0,
      _left: TreeNode = null,
      _right: TreeNode = null
  ) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def constructMaximumBinaryTree2(nums: Array[Int]): TreeNode = {
    val n: Int = nums.length
    val stack: mutable.Stack[Int] = mutable.Stack.empty[Int]
    val tree: Array[TreeNode] = Array.fill(n)(null: TreeNode)
    for (i <- 0 until n) {
      tree(i) = new TreeNode(nums(i))

      while (stack.nonEmpty && nums(i) > nums(stack.head)) {
        tree(i).left = tree(stack.pop())
      }

      if (stack.nonEmpty) {
        tree(stack.head).right = tree(i);
      }
      stack.push(i)
    }
    tree(stack(0));
  }

}
