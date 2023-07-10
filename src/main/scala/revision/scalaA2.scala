

package revision

object scalaA2 {
     			def main(args: Array[String]) = {

 /* Method 1:- When we have a condition for split */
     			  val k = List(1,2,3,4, 5, 6, 7, 8, 9)
      			
      			//apply partition to break list into 2 lists.
    				val (result1, result2) = k.partition(x => {x > 3})
    				
    				//print result
    				println("Method 1 output :" +"\n "+ result1)
     				println(" "+ result2)
     				
  /* Method 2:-  When we know the exact point to split */
     				println(s"Method 2 output : \n ${k.splitAt(3)}")
   			}
}


