import java.util.ArrayList;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        ArrayList<Integer> arrayList = new ArrayList<>(array.length);
        

        return answer;
    }


    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer;
        Solution sol = new Solution();

        answer = sol.solution(array, commands);
        for(int i = 0; i < answer.length ; i++){
            System.out.println(answer[i]);
        }
    }

}
