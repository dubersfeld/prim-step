package com.dub;

import com.dub.site.minimumSpanningTree.MinHeap;

public class MinHeapTest {

	public static void main(String[] args) {
		
		int[] keys = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
		
		MinHeap queue = new MinHeap(keys);
				
		queue.display();
		
		queue.build();
		
		queue.display();
			
		System.out.println("min " + queue.extractMin());
			
		queue.display();
		
		System.out.println("decreaseKey");
		queue.decreaseKey(2, 6);
		
		queue.display();
		
		System.out.println("isInQueue 7 " + queue.isInQueue(7));
		
		System.out.println("min " + queue.extractMin());
		
		System.out.println("isInQueue 7 " + queue.isInQueue(7));
		
	}

}
