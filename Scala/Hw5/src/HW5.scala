

object HW5 {
  def main(args: Array[String]) {
    
    // problem 1
    
    // only need to check up to Floor(sqrt(x)) to determine if a number is prime
    def is_prime(x:Int):Boolean = {
      
      def prime_iter(it:Int): Boolean = {
        if(it > math.sqrt(x)) true
        else if (x % it == 0) false
        else 
          prime_iter(it + 1)
      }
      
      prime_iter(2)
    }
    
    println(is_prime(50))
    println(is_prime(47))
    
    //problem 2
    
    def add_fth(x:Int, f:(Int)=>Int):Int = {

      if(x<1) 0

      else x+add_fth(f(x), f)

    }
    def third(x:Int):Int = x-3
    
    println(add_fth(9, third)) // 9 + 6 + 3 = 18
    
    // problem 3 
    
    def apply_combine( f:(Int)=>Int, x:Int, g:(Int, Int) => Int):Int = {
      if(x < 2) f(1)
      else g(f(x), apply_combine(f, x-1, g))
    }
    def mult(x:Int, y:Int) :Int = x*y
    def identity(x:Int) = x
    
    println(apply_combine(identity, 4, mult))
    println(apply_combine(x=>x*x,5,(x,y)=>x*y))
  }
  
  // problem 4
  def my_map (xs:List[Int], f:(Int)=>Int):List[Int] = {
    
    if(xs.tail.isEmpty) List(f(xs.head))
    else f(xs.head)::my_map(xs.tail, f)
  }
  
  def ls = List(1,2,3,4,5)
  def square(x:Int):Int = x*x
  println(my_map(ls, square))
}