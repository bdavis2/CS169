

object HW8P1Davis {
    def main(args:Array[String]) = {
      def ls = List(1,2,3,4,5)
       def square(x:Int):Int = x*x
       println(my_map[Int](ls, square))
    }
    
    def my_map[T](xs:List[T], f:(T)=>T):List[T] = {
      if(xs.isEmpty) xs
      else f(xs.head)::my_map(xs.tail, f)
    }
}