import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;


//https://www.youtube.com/watch?v=JUIwQBDHg0I

public class AvoidFloodinTheCity1488 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] avoidFlood(int[] rains) {
		int n = rains.length;
		int[] res = new int[n];
		// <下雨的湖泊，下雨天index>
		Map<Integer, Integer> map = new HashMap<>();
		// treeset存不下雨天index
		TreeSet<Integer> treeset = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			if (rains[i] != 0) {
				res[i] = -1;
				// 如果某个湖泊又下雨了
				if (map.containsKey(rains[i])) {
					// 找到这个湖泊第一次下雨天的index
					int day = map.get(rains[i]);
					// 如果treeset为空或者在day之后没有不下雨的天数则说明会发洪水
					if (treeset.isEmpty() || treeset.ceiling(day) == null) {
							return new int[0];
					}
					// 找到了某一天把水抽干
					res[treeset.ceiling(day)] = rains[i];
					// 记录当前湖泊最新一次的下雨天index
					map.put(rains[i], i);
					// 从treeset中去掉已经用掉的不下雨天index
					treeset.remove(treeset.ceiling(day));
				} else {
					map.put(rains[i], i);
				}
			} else {
				treeset.add(i);
			}
		}
		// 不下雨的天数全都去抽干第一个水池
		for (int i = 0; i < n; i++) {
			if (res[i] == 0) {
				res[i] = 1;
			}
		}
		return res;
	}

}
