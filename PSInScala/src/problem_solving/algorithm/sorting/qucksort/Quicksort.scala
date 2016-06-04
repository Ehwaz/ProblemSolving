package problem_solving.algorithm.sorting.qucksort

/**
  * Created by Sangwook on 2016-05-15.
  */
object QuicksortApp {
  // Ref: ScalaByExample ch.2
  def sortDecl(values: Array[Int]): Unit = {
    def swap(i: Int, j: Int): Unit = {
      val t = values(i)
      values(i) = values(j)
      values(j) = t
    }
    def sortDeclUtil(left: Int, right: Int): Unit = {
      val pivot = values((left + right) / 2)
      var i = left
      var j = right
      while (i <= j) {
        while (values(i) < pivot) i += 1
        while (values(j) > pivot) j -= 1
        if (i <= j) {
          swap(i, j)
          i += 1
          j -= 1
        }
      }
      if (left < j) sortDeclUtil(left, j)
      if (j < right) sortDeclUtil(i, right)
    }
    sortDeclUtil(0, values.length - 1)
  }

  def sortFunc(values: Array[Int]): Array[Int] = {
    if (values.length <= 1) values
    else {
      val pivot = values(values.length / 2)
      Array.concat(
        sortFunc(values filter(pivot >)),
        values filter(pivot ==),
        sortFunc(values filter(pivot <))
      )
    }
  }

  def main(args: Array[String]): Unit = {
    println("hello!")
    val values = Array(2, 3, 7, 3, 4, 10, 31, 24)
    sortDecl(values)
    println(values.mkString(" "))

    println(sortFunc(Array(2, 3, 7, 3, 4, 10, 31, 24)).mkString(" "))
  }
}
