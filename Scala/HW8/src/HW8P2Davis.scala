

object HW8P2Davis {
def main(args:Array[String]){
  val l = Leaf
  val t = new Node(4, l, l)
  val t2 = new Node(5, t, l)
  
  println(t2.max)
  println(t2.depth)
  println(t.exactsubtree(t2))
}
def max3(a:Int,b:Int,c:Int):Int = {
  if (a > b){
    if (a > c) a 
    else c
  }
  else {
    if (c > b) c
    else b
  }
}
abstract class BSTree{ //Can't be instantiated - can't make an object of type BSTree.
	def member(x: Int): Boolean//Tells us if x is in the BSTree
	def insert(x: Int): BSTree 
	//creates a new tree that is the same as this one, but with x added
	//def isLeaf:Boolean
	def equals(other:BSTree):Boolean
	
	//HW8 Problem 2
	def depth():Int
	def max():Int
	def exactsubtree(that:BSTree):Boolean
}
//Put case in front of all child types to allow pattern matching
case object Leaf extends BSTree{
  override def toString = "."
  def member(x: Int): Boolean = false
  def insert(x: Int): BSTree = new Node(x, Leaf, Leaf)
  //def isLeaf:Boolean = true
	def equals(other:BSTree):Boolean =
	  other match{
    case Leaf => true//Case 3
    case Node(v, l, r)=>false//Case 2
  }
  // HW8 Problem 2
  def depth():Int = 0 // leafs will never have children
  def max():Int = -1
  def exactsubtree(that:BSTree):Boolean = that match{
    case Leaf => false
    case Node(v, l, r) => false
  }
} 

case class Node(value:Int, left:BSTree, right:BSTree) extends BSTree{
  override def toString = "{"+left.toString+value.toString+right.toString+"}"
  def member(x: Int): Boolean = 
    if(x==value) true
    else if(x<value) left member x//left.member(x)
    else right member x //right.member(x)
  def insert(x: Int): BSTree = 
    if(x==value) new Node(value, left, right)//this
    else if(x>value) new Node(value, left, right insert x)
    else new Node(value, left insert x, right)

  //def isLeaf:Boolean =false
	def equals(other:BSTree):Boolean =
	  other match{
    case Leaf => false//Case 4
    case Node(v, l, r)=> 
      ((value==v) && (right equals r)  && (left equals l))//recursive call - left and right must both be equal
    //Case 1
  }
  
  
  
  // HW 8 Problem 2
  def depth():Int = {
     val d_left = left.depth()
     val d_right = right.depth()
     if (d_right > d_left) 1 + d_right else 1 + d_left
  }
  def max():Int = {
    val m_left = left.max()
    val m_right = right.max()
    max3(m_left, m_right, value)
  }
  def exactsubtree(that:BSTree):Boolean = that match{
    case Leaf => false
    case Node(v, l, r) => 
      if((this equals l) || (this equals r)) true
      else (this exactsubtree l) || (this exactsubtree r)
      
  }
}
}