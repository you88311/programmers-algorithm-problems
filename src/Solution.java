import java.util.TreeSet;

public class Solution {
    public int solution(int[] nums) {
        int answer = 0;


        return answer;
    }

public void combination (TreeSet<Integer> set){
        int[] window = {0, 1};
        while(window[1] < set.size() -1 ){
            for(int i = window[1] ; i < set.size() ; i++){

            }
            window[0]++;
            window[1]++;

        }

}


    public static void main(String[] args) {
        int[] testcase1 = {1, 2, 3, 4,};
        int[] testcase2 = {1, 2, 7, 6, 4};
        Solution sol = new Solution();
        System.out.println(sol.solution(testcase1));
    }

}
