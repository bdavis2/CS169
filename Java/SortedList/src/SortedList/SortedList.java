package SortedList;

import java.util.Arrays;

public class SortedList	{

		
		  private int arr[];
		  
		  //constructor that initializes the member field
		  public SortedList() {
			 arr = new int[0];
		  }
		  //constructor that takes in an initialized array 
		  public SortedList(int a[]) {
			  arr = Arrays.copyOf(a, a.length);
			  quicksort(0, arr.length-1);// guarantees that the list is always sorted, no matter the order we add elements
			  // i assume the intended implementation was something along the lines of repeatedly calling insert()
			  //but this implementation is technically less intensive, because my implementation of insert() calls quicksort anyway
		  }
		  
		// insert function that maintains sorted-ness
		public void insert(int a) {
			  arr = Arrays.copyOf(arr, arr.length +1);
			  arr[arr.length - 1] = a;
			  quicksort(0, arr.length - 1);
				//probably the laziest way i could think of inserting into a sorted list
				//just append to the end and then sort new array
				//obviously computationally slow, because you have to call quicksort which is never linear 
				//but, since quicksort is required for the problem, might as well get some mileage out of it
		}
		//partition function for quicksort
		public int partition(int p, int r) {
				int pivot = arr[r];
				 while ( p < r )
				    {
				        while ( arr[p] < pivot )
				            p++;

				        while ( arr[r] > pivot )
				            r--;

				        if ( arr[p] == arr[r] )
				            p++;
				        else if ( p < r )
				        {
				            int tmp = arr[p];
				            arr[p] = arr[r];
				            arr[r] = tmp;
				        }
				    }
				return r;
			}
		// quicksort
		public void quicksort(int p, int r) {
				if (p < r) {
					int j = partition(p, r);
					quicksort(p, j-1);
					quicksort(j+1, r);
				}
			}
		// binary search function
		  public void binarySearch(int search) {
			    int first, last, middle;
			    first  = 0;
			    last   = arr.length - 1;
			    middle = (first + last)/2;
			 
			    while( first <= last )
			    {
			      if ( arr[middle] < search )
			      {
			        first = middle + 1;    
			      }
			      else if ( arr[middle] == search ) 
			      {
			        System.out.println(search + " found at location " + middle + ".");
			        break;
			      }
			      else
			      {
			         last = middle - 1;
			      }
			      middle = (first + last)/2;
			   }
			   if ( first > last ) 
			   {
			      System.out.println(search + " is not present in the list.\n");
			   }
			   
		  }
		  
		  //print function
		  public void print(){
			  String pr = "{ ";
			  for(int i = 0; i < arr.length - 1; i++) {
				  pr += arr[i] + ", ";
			  }
			  pr += arr[arr.length-1] + " }";
			  System.out.println(pr);
		  }
}
		  
