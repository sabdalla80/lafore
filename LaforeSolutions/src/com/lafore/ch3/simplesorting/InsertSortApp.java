package com.lafore.ch3.simplesorting;

import java.util.Random;

//insertSort.java
//demonstrates insertion sort
//to run this program: C>java InsertSortApp
//--------------------------------------------------------------
class ArrayIns
{
private long[] a;                 // ref to array a
private int nElems;               // number of data items
//--------------------------------------------------------------
public ArrayIns(int max)          // constructor
   {
   a = new long[max];                 // create the array
   nElems = 0;                        // no items yet
   }
//--------------------------------------------------------------
public void insert(long value)    // put element into array
   {
   a[nElems] = value;             // insert it
   nElems++;                      // increment size
   }
//--------------------------------------------------------------
public void display()             // displays array contents
   {
   for(int j=0; j<nElems; j++)       // for each element,
      System.out.print(a[j] + " ");  // display it
   System.out.println("");
   }
//--------------------------------------------------------------
//Ex 3.5 - Comparisons and copies for InsertSort
public void insertionSort()
{
	
   int comparisons = 0, copies = 0;
   int in, out;

   for(out=1; out<nElems; out++)     // out is dividing line
      {
      long temp = a[out];            // remove marked item
      in = out;                      // start shifts at out
      
      while(in>0) // until one is smaller,
      {
    	  comparisons++; 
 		 
    	 if(a[in-1] >= temp){
           a[in] = a[in-1];            // shift item to right
           
           if(a[in-1] == temp)         //Ex 3.6 add this line to push duplicates to front
        	   temp = -1;
           
           --in;                       // go left one position
           copies++;                   //Inc Nuber of Copies
           
           
         }
    	 else
    		 break;
      }
      a[in] = temp; 
      }// end for
   
   System.out.println("comparisons= "+comparisons + " copies:"+ copies);

   }  // end insertionSort()
//--------------------------------------------------------------
//Ex 3.2
public long median(){
	int mid = nElems/2;
	if(nElems %2 ==1)
		return a[mid];
	else
		return (a[mid] + a[mid-1])/2;
	
}
////////////////////////////////////////////////////////////////
//Ex 3.3
//Remove Dups in sorted array in O(n)
//We just walk through elems, checking for dups in adjacent cells
//When we find a dup, we remove it, then we check if the dup appears multiple times so we can delete the rest of them
//e.g 0 11 22 33 44 44 44 55 66 77 88 99 where 44 appears many time ina row
public void noDups()
{
	for(int i=0; i< nElems; i++){
		if(a[i] == a[i+1]){
			removeAt(i+1);
			while(a[i] == a[i+1]){   //if the dup appears multiple times in a row, this loop deletes the all
					removeAt(i+1);
			}
		}
	}
}

public void removeAt(int index){
	
	int len = nElems;
	for(int i=index; i < len; i++){
		a[i] = a[i+1];
	}
	nElems--;
	
}
////////////////////////////////////////////////////////////////
}  // end class ArrayIns
////////////////////////////////////////////////////////////////
class InsertSortApp
{
public static void main(String[] args)
   {
   int maxSize = 1200;            // array size
   ArrayIns arr;                 // reference to array
   arr = new ArrayIns(maxSize);  // create the array

   arr.insert(77);               // insert 10 items
   arr.insert(99);
   arr.insert(44);
   arr.insert(55);
   arr.insert(44);
   arr.insert(22);
   arr.insert(88);
   arr.insert(11);
   arr.insert(44);
   arr.insert(00);
   arr.insert(66);
   arr.insert(88);
   arr.insert(33);
   arr.insert(44);
   
   /*
   //Ex 3.5  //Produces n(n-1)/2 efficiency ==> O(n^2)
   //Insert 1000 numbers to array to test efficiency of insertionSort
   Random r = new Random();;
   for(int i=0; i<1000; i++){
	   arr.insert(r.nextInt(100));  
   }
   */

   arr.display();                // display items

   arr.insertionSort();          // insertion-sort them

   arr.display();                // display them again
   
   System.out.println("median = "+arr.median());  //Ex 3.2
   
  // arr.noDups();            //Ex 3.3 
   
   arr.display();
   
   
   }  // end main()
}  // end class InsertSortApp
