import java.lang.Math;

public class Solution {

    public int[] solution(int[] lottos, int[] win_nums) {

        int erased_cnt = 0;
        int winning_cnt = 0;
        int j =0;

        for(int lot_num : lottos){
            if(lot_num == 0)
                erased_cnt++;
            else{
                for(int win_num : win_nums){
                    if(lot_num == win_num)
                        winning_cnt++;
                }
            }
        }

        int min = Math.min(7 - winning_cnt,6);
        int max = Math.min(7 - (winning_cnt + erased_cnt), 6);
        /*
        if(winning_cnt >=2) {
            min = 7 - winning_cnt;
            max = 7 - (winning_cnt + erased_cnt);
        }else {
            min = 6;
            if(winning_cnt + erased_cnt <2)
                max = 6;
            else
                max = 7 - (winning_cnt + erased_cnt);
        }
        */

        int[] answer = {max, min};
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        int[]answer =  s.solution(lottos,win_nums);

        System.out.printf("[%d, %d]",answer[0], answer[1]);
    }
}
