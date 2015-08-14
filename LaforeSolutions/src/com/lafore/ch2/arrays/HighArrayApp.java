package com.lafore.ch2.arrays;

//highArray.java
//demonstrates array class with high-level interface
//to run this program: C>java HighArrayApp
////////////////////////////////////////////////////////////////
class HighArray
{
private long[] a;                 // ref to array a
private int nElems;               // number of data items
//-----------------------------------------------------------
public HighArray(int max)         // constructor
   {
   a = new long[max];                 // create the array
   nElems = 0;                        // no items yet
   }
//-----------------------------------------------------------
public boolean find(long searchKey)
   {                              // find specified value
   int j;
   for(j=0; j<nElems; j++)            // for each element,
      if(a[j] == searchKey)           // found item?
         break;                       // exit loop before end
   if(j == nElems)                    // gone to end?
      return false;                   // yes, can't find it
   else
      return true;                    // no, found it
   }  // end find()
//-----------------------------------------------------------
public void insert(long value)    // put element into array
   {
   a[nElems] = value;             // insert it
   nElems++;                      // increment size
   }
//-----------------------------------------------------------
public boolean delete(long value)
   {
   int j;
   for(j=0; j<nElems; j++)        // look for it
      if( value == a[j] )
         break;
   if(j==nElems)                  // can't find it
      return false;
   else                           // found it
      {
      for(int k=j; k<nElems; k++) // move higher ones down
         a[k] = a[k+1];
      nElems--;                   // decrement size
      return true;
      }
   }  // end delete()
//-----------------------------------------------------------
public void display()             // displays array contents
   {
   for(int j=0; j<nElems; j++)       // for each element,
      System.out.print(a[j] + " ");  // display it
   System.out.println("");
   }
//-----------------------------------------------------------
//2.1
//Simply iterate thru array and keep track of the maximum number
public long findMax(){
	long max = -1;
	for(int i=0; i<nElems; i++){
		max = Math.max(max, a[i]);
	}
	return max;
}
//-------------------------------------------------------------
//2.2
//Reuse the max from ex 2.1 and use delete function to remove it
public long removeMax(){
	long max = findMax();
	if(max != -1){
		delete(max);
	}
	return max;
}
//-----------------------------------------------------------
//2.3
//Sort by reusing removeMax function
public long[] sortByRemovingMax(){
	//assign length for sorted array
	long sorted[] = new long[nElems];
	
	int length = nElems; //Can't use nElems because nElems will decrease as we remove Max numbers
	for(int i =0; i< length; i++){
		sorted[i] = removeMax();
	}
	
	return sorted;
}

}  // end class HighArray
////////////////////////////////////////////////////////////////
class HighArrayApp
{
public static void main(String[] args)
   {
   int maxSize = 100;            // array size
   HighArray arr;                // reference to array
   arr = new HighArray(maxSize); // create the array

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

   int searchKey = 35;           // search for item
   if( arr.find(searchKey) )
      System.out.println("Found " + searchKey);
   else
      System.out.println("Can't find " + searchKey);

   arr.delete(00);               // delete 3 items
   arr.delete(55);
   arr.delete(99);

   arr.display();                // display items again
   
   System.out.println("Max = "+ arr.findMax()); //Ex 2.1
   
   System.out.println("Remove Max = "+ arr.removeMax()); //Ex 2.2

   arr.display();  
   
   long [] sortedArr = arr.sortByRemovingMax();   //Ex 2.3
   System.out.print("Sorted: ");
   for(long s: sortedArr)
	   System.out.print(s+ " ");
   
   
   }  // end main()
}  // end class HighArrayApp

