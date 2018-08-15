package com.datumbrain.webfetcher
import org.jsoup.Jsoup
import sys.process._
import java.io._
import System._

object MainClass {
  
  def main(args : Array[String]) {
    
    // get response from url
    var response = Jsoup.parse(args(0))
    
    // create folder with name = url(cleaned)
    // get time stamp
    val timeStamp: Long = System.currentTimeMillis / 1000
    // generate folderName url(cleaned)+timeStamp
    var folderName = args(0).replaceAll("[^A-Za-z0-9]","")+timeStamp.toString()
    // make command
    var cmd = "mkdir "+ folderName;
    // execute command
    cmd.!!
    
    // create file output.html
    cmd = "touch " + folderName + "/output.html"
    cmd.!!
    
    // writting file output.html
    val pw = new PrintWriter(folderName+"/output.html")
    pw.write(response.toString())
    pw.close
  }
}
