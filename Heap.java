/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author moham
 */
public class Heap {

   private PriorityCustomer[] heap;
   private int size;
   public Heap first;
   public Heap last;
   
   public boolean isEmpty() {
        return size == 0;
    }
   
   public Heap () {
      heap = new PriorityCustomer[60];
      size = 0;
   }
   
   public Heap (int s) {
      heap = new PriorityCustomer [s];
      size = 0;
   }
   
   public int getSize () {
      return size;
   }
   
   public void add (PriorityCustomer c) {
      
      //Make sure the heap isn't full
      if (size + 2 > heap.length) {
         System.out.println ("The heap is full");
         return;
      }
      
      //increase the size
      size ++;
      
      //add new object to the next open position in the heap
      heap [size] = c;
      
      //create a variable to keep track of where our object is in the heap
      int index = size;
      
      //continue to compare the object to it's parents until it reaches the root
      while (index > 1) {
      
         //grab parent's index
         int parentIndex = index / 2;
      
         //compare object to it's parent to see if we need to swap it
         if (heap[index].getPriority()> heap[parentIndex].getPriority()) {
         
            //swap objects
            PriorityCustomer temporary = heap[index];
            heap[index] = heap[parentIndex];
            heap[parentIndex] = temporary;
            
            //update index to parent's index after swap
            index = parentIndex;
         if (isEmpty()) {
            first = last;
        } //else {
           // lastElement.next = last;
        //}
            //parent value is larger...no swap needed...break out
            break;
         }
      }   
   }
   
   public PriorityCustomer remove () {
      
      //make sure the heap isn't empty
      if (size == 0) {
         System.out.println ("The heap is already empty");
         return null;
      }
      
      //store temporary reference to root object, so we can we return it at the end
       PriorityCustomer temporary = heap [1];
      
      //move object in the last position to the root
      heap [1] = heap [size];
      heap [size] = null;
      size--;
      
      
      //store the index of the object we moved to the root
      int index = 1;
      
      //continue to compare index to its children as long as there are children
      while (index <= size / 2) {
      
         //store index and values of children
         int leftChildIndex = index * 2;
         int rightChildIndex = leftChildIndex + 1;
         
         int leftChildValue = heap [leftChildIndex].getPriority();
         int rightChildValue = Integer.MIN_VALUE;
         
         //is there a right child
         if (rightChildIndex <= size) {
            rightChildValue = heap [rightChildIndex].getPriority();
         }
          
         //determine the larger of the two children
         int largerValue;
         int largerIndex;
         
         if (rightChildValue > leftChildValue) {
            largerValue = rightChildValue;
            largerIndex = rightChildIndex;
         } else {
            largerValue = leftChildValue;
            largerIndex = leftChildIndex;
         }
         
         //determine if a swap should be made with the parent and the larger child
         if (heap[index].getPriority()< largerValue) {
         
            //swap
            PriorityCustomer swap = heap [index];
            heap [index] = heap [largerIndex];
            heap [largerIndex] = swap;
            
            //update the index since we moved it to a child position
            index = largerIndex;
         } else {
            //parent value is larger...no swap needed...break out
            break;
         }
         
      }
      
      //return the original root
      return temporary;
      
   }


}    

