package studio3;

import java.util.LinkedList;
import java.util.List;

public class UnorderedList<T extends Comparable<T>> implements PriorityQueue<T> {

	public LinkedList<T> list;
	
	public UnorderedList() {
		list = new LinkedList<T>();
	}
	
	@Override
	public boolean isEmpty() {
		
		if(list.isEmpty()) {
		
		return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public void insert(T thing) {
		list.add(thing);
	}

	@Override
	public T extractMin() {
		T base = list.getFirst();
		for(T thing:list) {
			
			if(thing.compareTo(base)<0 ) {
				base = thing;
				
			}
		}
		list.removeLastOccurrence(base);
		return base;
		
	}

}
