package com.datumbrain.webfetcher
import org.jsoup.Jsoup
import sys.process._
import Exception._
import java.io._
import System._
import java.io.File

object MainClass {

  def main(args: Array[String]) {

    // get response from url
    var response = Jsoup.parse(args(0))
    // create folder with name = url(cleaned)
    // get time stamp
    val timeStamp: String = (System.currentTimeMillis / 1000).toString()
    var urlCleaned = ""
    try {
      urlCleaned = args(0).replaceAll("[^A-Za-z0-9]", "")
    } catch {
      case ioe: IndexOutOfBoundsException => println("URL as argument needed.")
      case e: Exception                   => println(e.printStackTrace())
    }
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
  }
}
