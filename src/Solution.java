import java.util.ArrayList;
import java.util.Comparator;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<Integer> arrayList = new ArrayList<>();

        /*
        array의 숫자중
        command[*][0]번째 숫자부터 command[*][1]번째 숫자까지 내림차순으로 정렬 후
        command[*][2]번째에 있는 숫자가 answer
        */
        for(int i = 0 ; i < commands.length ; i++){
            arrayList.clear();
            for(int j = commands[i][0]-1; j < commands[i][1] ; j++ )
                arrayList.add(array[j]);
            arrayList.sort(Comparator.naturalOrder());
            answer[i] = arrayList.get(commands[i][2]-1);
        }

        return answer;
    }


    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer;
        Solution sol = new Solution();

        answer = sol.solution(array, commands);
        for(int i = 0; i < answer.length ; i++){
            System.out.print(answer[i] + " ");
        }
    }

}
