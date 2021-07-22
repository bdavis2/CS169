

object HW7p2 {
  
  
  
  def main(args:Array[String]){
    def x = List(1,1,1,2,2,3)
    println(findlast(x, 2))
    println(findlast(x,7))
    
    def l1 = List(1,2,3,4)
    def l2 = List(7,8,9,10,11,12)
    println(merge(l1,l2))
   
    
  }
  
  //problem 2


  // reverse list, then find first index of value, then subtract it from length.
  // uses 3 helper functions
  def findlast(xs:List[Int], x:Int):Int = {
      def length(xs:List[Int]):Int = xs match {
          case Nil => 0
          case y::ys => 1 + length(ys)
    }
      def reverselist(xs:List[Int]):List[Int] = {
        xs match {
          case Nil => xs
          case y::ys => reverselist(ys):::List(y)
        }
  }
      def helper(rev:List[Int]):Int = rev match{
        case Nil => 1
        case y::ys =>if (y == x) 1
                     else  1 + helper(ys)
    }
      length(xs) - helper(reverselist(xs))
  }
  
 // problem 3
  def merge(l1: List[Int], l2: List[Int]):List[Int] = l1 match {
    case Nil => l2
    case x::xs => x::merge(l2, xs)
  }
}