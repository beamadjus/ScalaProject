import scala.io.Source

object Project {

  def main(args: Array[String]) {

    val src = Source.fromFile("C:\\Users\\Bea Madjus\\Desktop\\test1.txt")

    for (line <- src .getLines()
      .flatMap(_.split("\\W+"))
      .filter(x => x.matches("[A-Za-z]+") )) {

     println(line)

    }
  }

  def countWords(text: String) = {
    val counts = scala.collection.mutable.Map.empty[String, Int].withDefaultValue(0)
    for (rawWord <- text.split("[ ,!.]+")) {
      val word = rawWord.toLowerCase;
      counts(word) += 1;
    }
    counts;

  }
}
