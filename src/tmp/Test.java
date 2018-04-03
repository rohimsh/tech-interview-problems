package tmp;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Test{

    public static void main(String args[])
    {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		queue.add(10);
		queue.add(8);
		queue.add(5);
		queue.add(3);
		queue.add(2);
		
		Iterator<Integer> itr = queue.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		queue.add(1);
		queue.add(7);
		
		Iterator<Integer> nitr = queue.iterator();
		
		while(nitr.hasNext()) {
			System.out.println(nitr.next());
		}
	}
}

