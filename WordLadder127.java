import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder127 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
//    	Map<String, List<String>> ladderMap = buildLadderMap(beginWord, wordList);
//    	Set<String> visited = new HashSet<>();
//    	
//    	Queue<String> queue = new LinkedList<>();
//        
//        queue.offer(beginWord);
//        visited.add(beginWord);
//        int step = 0;
//        while (!queue.isEmpty()) {
//        	int size = queue.size();
//        	step++;
//        	for (int i = 0; i < size; i++) {
//        		String temp = queue.poll();
//        		if (endWord.equals(temp))
//        			return step;
//        		List<String> nextLists = ladderMap.get(temp);
//        		for (String otherStr : nextLists) {
//        			if (!visited.contains(otherStr)) {
//	        			queue.offer(otherStr);
//	        			visited.add(temp);
//        			}
//        		}
//        	}
//        	
//        }
//       return step; 
//    }
//    
//    private static Map<String, List<String>> buildLadderMap(String beginWord, List<String> wordList) {
//    	Map<String, List<String>> ladderMap = new HashMap<>();
//    	
//    	for (String word : wordList) {
//    		List<String> nextList = new LinkedList<>();
//    		ladderMap.put(word, nextList);
//    		for (String otherWord : wordList) {
//    			if (!otherWord.equals(word)) {
//    				if (countDiff(word, otherWord) == 1) {
//    					nextList.add(otherWord);
//    				}
//    			}
//    		}
//    	}
//    	
//    	if (!ladderMap.containsKey(beginWord)) {
//	    	List<String> nextList = new LinkedList<>();
//			ladderMap.put(beginWord, nextList);
//	    	for (String otherWord : wordList) {
//				if (!otherWord.equals(beginWord)) {
//					if (countDiff(beginWord, otherWord) == 1) {
//						nextList.add(otherWord);
//					}
//				}
//			}
//    	}
//    	return ladderMap;
//    }
//
//	private static int countDiff(String word, String otherWord) {
//		if (word != null || otherWord == null || word.length() != otherWord.length())
//			return -1;
//		
//		int diffCount = 0;
//		for (int i = 0; i < word.length(); i++) {
//			if (word.charAt(i) != otherWord.charAt(i)) {
//				diffCount++;
//			}
//		}
//		
//		return diffCount;
//	}
	
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Map<String, List<String>> map = new HashMap<>();
		Set<String> visited = new HashSet<>();
		
		buildMap(wordList, beginWord, map);
		
		Deque<String> queue = new ArrayDeque<>();
		int step = 0;
		
		queue.offer(beginWord);
		visited.add(beginWord);
		
		while (!queue.isEmpty()) {
			int queueSize = queue.size();
			step++;
			for (int i = 0; i < queueSize; i++) {
				String currWord = queue.poll();
				if (currWord.equals(endWord)) {
					return step;
				}
				List<String> nextList = map.get(currWord);
				for (String word : nextList) {
					if (!visited.contains(word)) {
						queue.offer(word);
						visited.add(word);
					}
				}
			}
		}
		
		return 0;
	}

	private static void buildMap(List<String> wordList, String beginWord, Map<String, List<String>> map) {
		
		for (String word : wordList) {
			List<String> nextList = new LinkedList<>();
			map.put(word, nextList);
			for (String otherWord : wordList) {
				if (!otherWord.equals(word) && diffCount(word, otherWord) == 1) {
					nextList.add(otherWord);
				}
			}
		}
		
		if (!map.containsKey(beginWord)) {
			List<String> nextList = new LinkedList<>();
			map.put(beginWord, nextList);
			for (String word : wordList) {
				if (!word.equals(beginWord) && diffCount(word, beginWord) == 1) {
					nextList.add(word);
				}
			}
		}
	}

	private static int diffCount(String word, String otherWord) {
		int diffCount = 0;
		
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) != otherWord.charAt(i)) {
				diffCount++;
			}
		}
		
		return diffCount;
	}

}
