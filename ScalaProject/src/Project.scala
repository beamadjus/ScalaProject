import scala.io.Source

object Project {

  def main(args: Array[String]) {

    var words = Scala.fromFile("book.txt","ISO-8859-1")

      .getLines
      .flatMap(_.split("\\W+"))
      .filter(x => x.matches("[A-Za-z]+") && x.length>1)
      .foldLeft(Map.empty[String, Int]){

        (count, word) => count + (word -> (count.getOrElse(word, 0) + 1))

    }

    val writer = new PrintWriter(new File("wordCount.txt"))

    val sort = ListMap(words.toSeq.sortBy(_._1.toLowerCase):_*)

    for ((k,v) <- sort) {
      val string = "%s - %s".format(k,v)
      writer.write(string + "\n")
    }
    writer.close()
  }

}
