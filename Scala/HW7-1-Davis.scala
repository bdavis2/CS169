

class Biguint(list:List[Int]) {
  val l = list
  def this() = this(0::Nil)
  def this(s:String) = this({def convert(s:String):List[Int] = {if(s.isEmpty) Nil else convert(s.tail):::List((s.head-'0'))}; convert(s)})
  
  def +(that:Biguint):Biguint = {

    def helper(xs:List[Int], ys:List[Int], carry:Int):List[Int] = xs match {
      case Nil => if(ys.isEmpty) if(carry == 1) 1::xs else xs
                  else{ 
                      def w = carry + ys.head 
                      (w % 10)::helper(xs, ys.tail, w/10)
                  }
      case xh::xt => ys match {
        case Nil => (xh+carry)::xt
        case yh::yt => def v = xh+yh+carry
          (v % 10)::(helper(xt,yt, v/10))
        }
      }
                  
    new Biguint(helper(l,that.l,0))
  }
}

object HW7p1 {
  
  
  def main(args:Array[String]){
   def x = new Biguint("8")
   def y = new Biguint("8")
   
   println((x+y).l)
   
    
  }
}