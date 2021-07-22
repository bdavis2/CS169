

object HW8P3Davis {
  def main(args:Array[String]){
    def square(x:Int):Int = x*x
    def foo(x:Int, y:Int, z:Int):Int = if(x==y) x*x else z
    
    foo(1+3, 2+2, 5)
    foo(1, 1, 6+8*square(3))
    foo(1+3, square(2), 4+square(5))
    foo(3*2, 12, 6)
  }
}