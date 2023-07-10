package revision
import scala.collection.immutable._

object palindromedetector {
  
  def main(args: Array[String]) {
  
    val lc = "kUaUK"
    val ls = lc.toLowerCase().reverse
    //println(ls)
    println(isPalindrome("tacat"))
    println(isPalindrome(lc))
    isPalindrome("Kayak")
    isPalindrome("topoT")
    isPalindrome("return")

  }
  
  def isPalindrome(word :String) :Boolean = {
    //println(word)
    val lr = word.toLowerCase()
   if(lr == lr.reverse)
     return true
   else 
     return false
    
  }  
  
}