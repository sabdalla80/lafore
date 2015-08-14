package com.lafore.ch2.arrays;

//orderedArray.java
//demonstrates ordered array class
//to run this program: C>java OrderedApp
////////////////////////////////////////////////////////////////
class OrdArray
{
private long[] a;                 // ref to array a
private int nElems;               // number of data items
//-----------------------------------------------------------
public OrdArray(int max)          // constructor
   {
   a = new long[max];             // create array
   nElems = 0;
   }
//-----------------------------------------------------------
public int size()
   { return nElems; }
//-----------------------------------------------------------
public int find(long searchKey)
   {
   int lowerBound = 0;
   int upperBound = nElems-1;
   int curIn;

   while(true)
      {
      curIn = (lowerBound + upperBound ) / 2;
      if(a[curIn]==searchKey)
         return curIn;              // found it
      else if(lowerBound > upperBound)
         return nElems;             // can't find it
      else                          // divide range
         {
         if(a[curIn] < searchKey)
            lowerBound = curIn + 1; // it's in upper half
         else
            upperBound = curIn - 1; // it's in lower half
         }  // end else divide range
      }  // end while
   }  // end find()
//-----------------------------------------------------------
public void insert(long value)    // put element into array
   {
   int j;
   for(j=0; j<nElems; j++)        // find where it goes
      if(a[j] > value)            // (linear search)
         break;
   for(int k=nElems; k>j; k--)    // move bigger ones up
      a[k] = a[k-1];
   a[j] = value;                  // insert it
   nElems++;                      // increment size
   }  // end insert()
//-----------------------------------------------------------

//2.4
//This function will return the index/spot at which we will insert or delete a value
//Using a binarySearch O(log(n)
private int findSpot(long value){
	int spot=0;
	int low = 0;
	int hi = nElems-1;
	while(true){
		int mid = low + (hi-low)/2; 
		//Am I in upper half?
		if(a[mid]<= value){ 
			if(a[mid+1] > value){
			  spot = mid+1;
			  break;
			}
			low = mid;
		}
		//Am I in lower half
		else if(a[mid] >= value){
			
			if(a[mid-1] < value){
			  spot = mid;
			  break;
			}
			hi = mid;
		}
	}
	
	return spot;
}
//2.4
public void binaryinsert(long value)    // put element into array
{
	//Find spot of insertion using Binary Search
	int j = findSpot(value);
	
	for(int k=nElems; k>j; k--)    // move bigger ones up
		a[k] = a[k-1];
	a[j] = value;                  // insert it
	nElems++;                      // increment size
}  // end insert()
//-----------------------------------------------------------
public boolean delete(long value)
   {
   int j = find(value);
   if(j==nElems)                  // can't find it
      return false;
   else                           // found it
      {
      for(int k=j; k<nElems; k++) // move bigger ones down
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
//2.5 
//merge two sorted arrays into one sorted array - take care of case when one array 
//is exhausted before the other
public long[] merge(long []s1, long []s2){
	int resLength = s1.length+s2.length;
	long []result = new long[resLength];
	
	int i=0,j=0,k=0;

	while(i<= s1.length-1 && j <= s2.length-1){
			if(s1[i] < s2[j]){
			    result[k++]= s1[i];
				i++;
			}
			else{
				result[k++]= s2[j];
				j++;
			}
	}
	
	//if array2 exhausted before array1
	int e = s1.length-1;
	while(i<e){	
		result[k++] = s1[i++];
	}
	
	//if array1 exhausted before array2
	e = s2.length-1;
	while(j < e){
		result[k++] = s2[j++];
	}
	return result;
}

//Ex 2.6
// Remove Duplicates by placing nulls or -1 and then removing the duplicates
void noDups(){
	for(int i=0; i<nElems; i++){
		for(int j = i+1; j< nElems; j++){
			if(a[i] == a[j])
				a[j] = -1;
		}
	}
}


}  // end class OrdArray

////////////////////////////////////////////////////////////////
class OrderedApp
{
public static void main(String[] args)
   {
   int maxSize = 100;             // array size
   OrdArray arr;                  // reference to array
   arr = new OrdArray(maxSize);   // create the array

   arr.insert(77);                // insert 10 items
   arr.insert(99);
   arr.insert(44);
   arr.insert(55);
   arr.insert(22);
   arr.insert(88);
   arr.insert(11);
   arr.insert(00);
   arr.insert(66);
   arr.binaryinsert(22);  //Ex 2.4
   arr.binaryinsert(33); 
   arr.binaryinsert(62);
   arr.binaryinsert(64);
   arr.binaryinsert(67);
   arr.binaryinsert(22);


   int searchKey = 55;            // search for item
   if( arr.find(searchKey) != arr.size() )
      System.out.println("Found " + searchKey);
   else
      System.out.println("Can't find " + searchKey);

   arr.display();                 // display items

   arr.delete(00);                // delete 3 items
   arr.delete(55);
   arr.delete(99);

   arr.display();                 // display items again
   
   long [] s1 = {4,6,7,8,9,20,15, 30,22};
   long [] s2 = {0,1,2,5,10};
   long []mergedArr = arr.merge(s1, s2);
   
   System.out.println();
   
   System.out.println("remove Dups");
   arr.noDups();
   arr.display();
   
   }  // end main()
}  // end class OrderedApp
