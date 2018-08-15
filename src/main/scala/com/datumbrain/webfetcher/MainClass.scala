package com.datumbrain.webfetcher
import org.jsoup.Jsoup
import sys.process._
import java.io._
import System._
import java.io.File


object MainClass {
  
  def main(args : Array[String]) {
    
    // get response from url
    var response = Jsoup.parse(args(0))
    
    // create folder with name = url(cleaned)
    // get time stamp
    val timeStamp: Long = System.currentTimeMillis / 1000
    // generate folderName url(cleaned)+timeStamp
    var folderName = args(0).replaceAll("[^A-Za-z0-9]","")+timeStamp.toString()

    // the folders doesn't exist initially
    var dir :File = new File(folderName);
    
    // create folder
    val successful: Boolean = dir.mkdirs()
    
    // writting file output.html
    val pw = new PrintWriter(folderName+"/output.html")
    pw.write(response.toString())
    pw.close
  }
}
