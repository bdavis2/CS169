

object HW6{
  def main(args: Array[String]) {
    
    def l1 = List(3,8,1,5)
    def l2 = List(12,6,23,1,8,4)
    def add(x:Int,y:Int):Int = x+y
    println(list_combine(l1,l2,add))
    
    
    def list_add = list_combine2(add)
    println(list_add(l1,l2))
    
    //problem 5 testing
    // with named functions
    def apply_square = apply_combine2(x=>x*x)
    def apply_square_then_mult = apply_square((x,y)=>x*y)
    println(apply_square_then_mult(5))
    
    // with anonymous functions
    def apply_square2 = apply_combine3(x=>x*x)
    def apply_square_then_mult2 = apply_square2((x,y)=>x*y)
    println(apply_square_then_mult2(5))
  }

// problem 2
  def list_combine(xs:List[Int], ys:List[Int], f:(Int, Int)=>Int):List[Int] = {
    if(xs.tail.isEmpty || ys.tail.isEmpty) List(f(xs.head,ys.head))
    else f(xs.head,ys.head)::list_combine(xs.tail,ys.tail,f)
  }
  //problem 3
  def list_combine2(f:(Int, Int)=> Int):(List[Int],List[Int])=>List[Int] = {
    (xs:List[Int], ys:List[Int]) => 
      if (xs.tail.isEmpty || ys.tail.isEmpty) List(f(xs.head,ys.head))
      else f(xs.head,ys.head)::list_combine2(f)(xs.tail,ys.tail)
  }


//problem 4, using anonymous function
  def curried_map(f:(Int)=>Int):(List[Int])=>List[Int] = {
    (xs:List[Int]) =>
      if (xs.tail.isEmpty) List(f(xs.head))
      else f(xs.head)::curried_map(f)(xs.tail)
  }
  
//problem 5: named functions
  def apply_combine2(f:Int=>Int):((Int,Int)=>Int)=>((Int)=>Int) = {
    def inner(g:(Int,Int)=>Int):Int=>Int = {
      def innerinner(x:Int):Int = {
        if (x < 2) f(1)
        else g(f(x), innerinner(x-1))
      }
      innerinner
    }
    inner
  }
  
// problem 5:anonymous
  def apply_combine3(f:Int=>Int):((Int,Int)=>Int)=>((Int)=>Int) = {
    (g:(Int,Int)=>Int) =>
      (x:Int) =>
        if (x < 2) f(1)
        else g(f(x), apply_combine3(f)(g)(x-1))
  }

}