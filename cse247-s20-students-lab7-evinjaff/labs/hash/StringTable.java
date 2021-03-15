package hash;

import java.util.LinkedList;

//
// STRINGTABLE.JAVA
// A hash table mapping Strings to their positions in the the pattern sequence
// You get to fill in the methods for this part.
//
public class StringTable {

	private LinkedList<Record>[] buckets;
	private int nBuckets;

	//
	// number of records currently stored in table --
	// must be maintained by all operations
	//
	public int size;

	//
	// Create an empty table with nBuckets buckets
	//

	@SuppressWarnings("unchecked")
	public StringTable(int nBuckets) {
		this.nBuckets = nBuckets;
		this.buckets = new LinkedList[nBuckets];
		
		for(int i=0;i<this.buckets.length;i++) {
			this.buckets[i] = new LinkedList<Record>();
		}
		
		this.size = 0;
	}

	/**
	 * insert - inserts a record to the StringTable
	 *
	 * @param r
	 * @return true if the insertion was successful, or false if a record with the
	 *         same key is already present in the table.
	 */
	public boolean insert(Record r) {
		
		// TODO - implement this method

		// int hashins = (int) Math.floor(()*this.nBuckets);

		int hashins = toIndex(stringToHashCode(r.key));
		
		//LinkedList<Record> temp = this.buckets[hashins]; 
		
		for (int i = 0; i < this.buckets[hashins].size(); i++) {
			if (r.key.equals(this.buckets[hashins].get(i).key)) {
				return false;
			}
		}
		
		if(this.buckets[hashins].add(r) == false) {
			
			return false;
		
		}
		
		else {
			
			this.size++;

			return true;
		}

		
		 
		  
		
		
		
		/*

		this.buckets[hashins].add(r);

		this.size++;

		return true;
		*/
		
		
		
	}

	/**
	 * find - finds the record with a key matching the input.
	 *
	 * @param key
	 * @return the record matching this key, or null if it does not exist.
	 */
	public Record find(String key) {
		// TODO - implement this method
		//try {
		
		int index = toIndex(stringToHashCode(key));
		if(this.buckets[index] != null) {
		for(int i=0;i<this.buckets[index].size();i++) {
			if(this.buckets[index].get(i).key.equals(key)) {
				return this.buckets[index].get(i);
			}
		}
		}
		//catch(Exception NullPointerException) {
		else {
			return null;
		}
		
		
		return null;
	}

	/**
	 * remove - finds a record in the StringTable with the given key and removes the
	 * record if it exists.
	 *
	 * @param key
	 */
	public void remove(String key) {
		// TODO - implement this method
		// TODO - implement this method
				int index = toIndex(stringToHashCode(key));
				//if(this.buckets[index] != null) {
				//try {
				for(int i=0;i<this.buckets[index].size();i++) {
					if(this.buckets[index].get(i).key.equals(key)) {
						this.buckets[index].remove(i);
						this.size--;
						return;
					}
				//}
				//}
				}
				
				//catch(Exception NullPointerException) {
				//else {
					return;
				//}
				//}
				 
		
		
	}

	/**
	 * toIndex - convert a string's hashcode to a table index
	 *
	 * As part of your hashing computation, you need to convert the hashcode of a
	 * key string (computed using the provided function stringToHashCode) to a
	 * bucket index in the hash table.
	 *
	 * You should use a multiplicative hashing strategy to convert hashcodes to
	 * indices. If you want to use the fixed-point computation with bit shifts, you
	 * may assume that nBuckets is a power of 2 and compute its log at construction
	 * time. Otherwise, you can use the floating-point computation.
	 */
	private int toIndex(int hashcode) {

		// Fill in your own hash function here
		int c = hashcode;

		double A = 0.61803398874989484820458683436564; // Knuth #

		double index = ((A * c) % 1) * this.nBuckets;

		if (index < 0) {
			index *= -1;
		}

		int cleanedToIndicies = (int) index;
		
		return cleanedToIndicies;
	}

	/**
	 * stringToHashCode Converts a String key into an integer that serves as input
	 * to hash functions. This mapping is based on the idea of integer
	 * multiplicative hashing, where we do multiplies for successive characters of
	 * the key (adding in the position to distinguish permutations of the key from
	 * each other).
	 *
	 * @param string to hash
	 * @returns hashcode
	 */
	int stringToHashCode(String key) {
		int A = 1952786893;

		int v = A;
		for (int j = 0; j < key.length(); j++) {
			char c = key.charAt(j);
			v = A * (v + (int) c + j) >> 16;
		}

		return v;
	}

	/**
	 * Use this function to print out your table for debugging purposes.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < nBuckets; i++) {
			sb.append(i + "  ");
			if (buckets[i] == null) {
				sb.append("\n");
				continue;
			}
			for (Record r : buckets[i]) {
				sb.append(r.key + "  ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
