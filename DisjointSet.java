//https://www.techiedelight.com/disjoint-set-data-structure-union-find-algorithm/

import java.util.HashMap;
import java.util.Map;

	public class DisjointSet {
		Map<Integer, Integer> parentMap = new HashMap<>();
		
		// stores the depth of trees
		Map<Integer, Integer> rankMap = new HashMap<>();
		
		DisjointSet(int n) {
			makeSet(n);
		}
		
		public void makeSet(int total) {
			// Initially, all elements are in their own set. 
	        for (int i = 0; i < total; i++) {
	        	parentMap.put(i, i);
	        	rankMap.put(i, 0);
	        }
		}
		
		public void makeSet(int[] universe) {
			for (int i : universe) {
				parentMap.put(i, i);
				rankMap.put(i, 0);
			}
		}
		
		public void makeSet(char[] universe) {
			for (char i : universe) {
				parentMap.put(i-'a', i-'a');
				rankMap.put(i-'a', 0);
			}
		}
		
		// Find the root of the set in which element belongs
		public int find(int element) {
			// if element is not root
			if (parentMap.get(element) != element) {
				// path compression
				parentMap.put(element, find(parentMap.get(element)));
			}
			
			return parentMap.get(element);
		}
		
		// Find the root of the set in which element belongs
		public int find(char element) {
			// if element is not root
			if (parentMap.get(element - 'a') != element - 'a') {
				// path compression
				parentMap.put(element - 'a', find(parentMap.get(element - 'a')));
			}
			
			return parentMap.get(element - 'a');
		}
		
		// Perform Union of two subsets
		public void union(int a, int b) {
			// find root of the sets in which elements
			// x and y belongs
			int x = find(a);
			int y = find(b);
			
			// if x and y are present in same set
			if (x == y)
				return;
			
			// Always attach smaller depth tree under the
			// root of the deeper tree.
			if (rankMap.get(x) < rankMap.get(y)) {
				parentMap.put(x, y);
			} else if (rankMap.get(x) > rankMap.get(y)) {
				parentMap.put(y, x);
			} else {
				parentMap.put(x, y);
				rankMap.put(y, rankMap.get(y) + 1);
			}
		}
		
		// Perform Union of two subsets
		public void union(char a, char b) {
			// find root of the sets in which elements
			// x and y belongs
			int x = find(a - 'a');
			int y = find(b - 'a');
			
			// if x and y are present in same set
			if (x == y)
				return;
			
			// Always attach smaller depth tree under the
			// root of the deeper tree.
			if (rankMap.get(x) < rankMap.get(y)) {
				parentMap.put(x, y);
			} else if (rankMap.get(x) > rankMap.get(y)) {
				parentMap.put(y, x);
			} else {
				parentMap.put(x, y);
				rankMap.put(y, rankMap.get(y) + 1);
			}
		}
	}

