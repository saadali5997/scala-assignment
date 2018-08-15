package com.datumbrain.webfetcher
import org.jsoup.Jsoup.connect
import Exception._
import java.io._
import System._
import java.net.URL

object MainClass {

  def main(args: Array[String]) {
    try {
      val url = new URL(args(0))
      // get response from url
      val response = connect(args(0).toString()).get()
      val urlCleaned = args(0).replaceAll("[^A-Za-z0-9]", "")
      // create folder with name = url(cleaned)
      // get time stamp
      val timeStamp: String = (System.currentTimeMillis).toString()
      // generate folderName url(cleaned)+timeStamp
      var folderName = f"$urlCleaned%s $timeStamp%s"
      // the folders doesn't exist initially
      var dir: File = new File(folderName);
      // create folder
      val successful: Boolean = dir.mkdirs()
      // writting file output.html
      val pw = new PrintWriter(folderName + "/output.html")
      pw.write(response.toString())
      pw.close
    } catch {
      case ioe: java.lang.ArrayIndexOutOfBoundsException => println("URL as argument needed.")
      case url: java.net.MalformedURLException => println("Please enter a valid URL.")
      case e: Exception                                  => println(e.printStackTrace())
    }
  }
}
