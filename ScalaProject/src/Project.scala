import scala.io.Source

object Project {
  val src = Source.fromFile("C:\\Users\\ISTUDENT\\Documents\\MobCom\\file.txt");

  def main(args: Array[String]) {

    textFile();
    //print(countWords(src));

  }

  def textFile(): Unit = {

    for (line <- src.getLines()) {
      println(line)
    }
  }

  /*def wordCount(source: Source): Long = {
    var newlineCount = 0L
    for (line <- source.getLines) {
      newlineCount += 1
    }
    newlineCount
  }*/

  def countWords(text: String) = {
    val counts = scala.collection.mutable.Map.empty[String, Int].withDefaultValue(0)
    for (rawWord <- text.split("[ ,!.]+")) {
      val word = rawWord.toLowerCase;
      counts(word) += 1;
    }
    counts;

  }
}