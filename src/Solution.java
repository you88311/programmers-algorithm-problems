import java.lang.Math;

/*숫자문자열과 영단어 프로그래머스 lv1*/

public class Solution {

    public int[] solution(int[] lottos, int[] win_nums) {

        int erased_cnt = 0;
        int winning_cnt = 0;
        int j = 0;

        for (int lot_num : lottos) {
            if (lot_num == 0)
                erased_cnt++;
            else {
                for (int win_num : win_nums) {
                    if (lot_num == win_num)
                        winning_cnt++;
                }
            }
        }

        int min = Math.min(7 - winning_cnt, 6);
        int max = Math.min(7 - (winning_cnt + erased_cnt), 6);

        return new int[]{max, min};
    }

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        Solution sol = new Solution();

        int[] answer = sol.solution(lottos, win_nums);
        System.out.printf("[%d, %d]",answer[0],answer[1]);
    }

}