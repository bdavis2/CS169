package SortedList;

import java.util.Scanner;

public class HW3P3 {
	  public static void main(String args[]){
		    int c, n, search, ins, array[];
		 
		    Scanner in = new Scanner(System.in);
		    System.out.println("Enter number of elements");
		    n = in.nextInt(); 
		    array = new int[n];
		 
		    System.out.println("Enter " + n + " integers");
		 
		    for (c = 0; c < n; c++)
		      array[c] = in.nextInt();
		 
		    System.out.println("Enter value to find");
		    search = in.nextInt();

		    SortedList sl = new SortedList(array);
		    sl.print();
		    
		    sl.binarySearch(search);
		    
		    //illustrating insert working
		    System.out.println("Insert new number");
		    ins = in.nextInt();
		    sl.insert(ins);
		    
		    sl.print();
		    in.close();
		  }
}
