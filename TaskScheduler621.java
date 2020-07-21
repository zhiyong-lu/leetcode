import java.util.Arrays;

public class TaskScheduler621 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	https://www.youtube.com/watch?v=OQKpjr13VNk
    public static int leastInterval(char[] tasks, int n) {
        if (tasks == null) return 0;
        int[] taskCount = new int[26];
        
        for (char c : tasks) {
        	taskCount[c - 'A']++; //A6, B4,...
        }
        
        Arrays.sort(taskCount);
        
        int max_row = taskCount[25] - 1;
        int space = max_row * n;
        
        for (int i = 24; i >= 0 && taskCount[i] > 0; i--) {
        	space -= Math.min(max_row, taskCount[i]);
        }
        
        return space > 0 ? tasks.length + space:tasks.length;
    }
	
}
