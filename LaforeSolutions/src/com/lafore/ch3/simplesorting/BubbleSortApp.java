package com.lafore.ch3.simplesorting;

//bubbleSort.java
//demonstrates bubble sort
//to run this program: C>java BubbleSortApp
////////////////////////////////////////////////////////////////
class ArrayBub
{
private long[] a;                 // ref to array a
private int nElems;               // number of data items
//--------------------------------------------------------------
public ArrayBub(int max)          // constructor
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
//Ex 3.1
public void bubbleSort()
   {
   int outR=0;    //index right
   int outL = 0;  //index left 
   int in;  //inner index to iterate in both directions
   
   //bidirectional, carry highest towards outR, once there, walk backwards and carry min to outL
   //Advance both Left and right indices and narrow down the sort

   for(outR=nElems-1; outR>1; outR--){   // outer loop (backward)
	   
	   //carry highest to right
      for(in=outL; in<outR; in++) {       // inner loop (forward)
         if( a[in] > a[in+1] )       // out of order?
            swap(in, in+1);          // swap them
      }
      //Ok, now we are at outR, we need to walk in opp direction and carry minimum towards outL
      //carry minimum to Left
      for(in = outR-1; in > outL; in--){
    	  if(a[in] < a[in-1])
    		  swap(in, in-1);
      }
      outL++;
   }
   }  // end bubbleSort()
//------------------------------------------------------------------------------
//Ex 3.4 OddEven Sort
//one pass on even pairs
//pass on Odd pairs

public void OddEvenSort ()
{
    for (int i = 0 ; i < nElems ; i++)
    {
         if (i%2 !=0) // 'i' is odd
         {
             for (int j = 2 ; j < nElems ; j += 2)
             {     
                  if (a[j] < a[j-1])
                      swap (j-1,j) ;
             }
          }
          else  // 'i' is even
          {  
              for (int j = 1 ; j < nElems ; j += 2)
              {
                   if (a[j] < a[j-1])
                       swap (j-1,j) ;
              } 
          }
    }
}
//--------------------------------------------------------------
private void swap(int one, int two)
 {
     long temp = a[one];
     a[one] = a[two];
     a[two] = temp;
 }
//--------------------------------------------------------------
}  // end class ArrayBub
////////////////////////////////////////////////////////////////
class BubbleSortApp
{
public static void main(String[] args)
   {
   int maxSize = 100;            // array size
   ArrayBub arr;                 // reference to array
   arr = new ArrayBub(maxSize);  // create the array

   arr.insert(77);               // insert 10 items
   arr.insert(99);
   arr.insert(44);
   arr.insert(55);
   arr.insert(22);
   arr.insert(88);
   arr.insert(11);
   arr.insert(00);
   arr.insert(66);
   arr.insert(33);

   arr.display();                // display items
   
   arr.OddEvenSort();   //Ex 3.4  OddEvenSort
  // arr.bubbleSort();             // bubble sort them

   arr.display();                // display them again
   }  // end main()
}  // end class BubbleSortApp
////////////////////////////////////////////////////////////////

