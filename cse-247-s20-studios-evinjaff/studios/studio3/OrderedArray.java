package studio3;

public class OrderedArray<T extends Comparable<T>> implements PriorityQueue<T> {

	public T[] array;
	private int size;
	
	@SuppressWarnings("unchecked")
	public OrderedArray(int maxSize) {
		array = (T[]) new Comparable[maxSize];
		size = 0;
	}
	
	@Override
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		for(int i=0;i<array.length;i++) {
			if(array[i] != null) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void insert(T thing) {
		T temp;
		
		int index = 0;
		for(int i=0;i<array.length;i++) {
			if(array[i] == null) {
				return;
			}
			if(array[i].compareTo(thing) > 0) {
				temp = array[i];
				array[i] = thing;
				index = i;
				break;
			}
		}
		for(int i=index+1;i<array.length;i++) {
			temp = array[i];
			array[i] = array[i+1];
		}
		
		
	}
	
	@Override
	public T extractMin() {
		//
		// FIXME
		//
		return null;
	}

}
