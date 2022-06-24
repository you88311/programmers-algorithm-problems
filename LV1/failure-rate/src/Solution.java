import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Double[][] failureRate = new Double[N][2];
        //2차원배열 failureRate 첫 번째 숫자: stage level 두 번째 숫자: 실패율
        int notCleardUsers = 0;
        int reachedUsers = 0;

        for (int i = 0; i < N; i++) {
            failureRate[i][0] = (double) (i + 1); //stage level 저장
            notCleardUsers = 0;
            reachedUsers = 0;

            for (int stage : stages) {
                if (stage > i + 1)
                    reachedUsers++;
                else if (stage == i + 1) {
                    reachedUsers++;
                    notCleardUsers++;
                }
            }
            /*실패율 저장*/
            if (reachedUsers == 0)
                failureRate[i][1] = 0.0; //아무도 도달 못했으면 실패율 0
            else
                failureRate[i][1] = ((double) notCleardUsers / (double) reachedUsers);
        }

        /*2차원 배열 failureRate[*][이거 기준] 정렬*/
        Arrays.sort(failureRate, new Comparator<Double[]>() {
            @Override
            public int compare(Double[] o1, Double[] o2) {
                return Double.compare(o2[1], o1[1]);
            }
        });

        //Double배열 문제 조건에 따라 int배열로 변환
        double tmp;

        for (int i = 0; i < failureRate.length; i++) {
            tmp = failureRate[i][0]; //Double to double
            answer[i] = (int) tmp;   //double to int
        }


        return answer;
    }

    public static void main(String[] args) {
        int N1 = 5;
        int N2 = 4;
        int[] stages1 = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] stages2 = {4, 4, 4, 4, 4};
        int[] answer;
        Solution sol = new Solution();

        /*testcase1*/
        answer = sol.solution(N1, stages1);
        for (int i = 0; i < answer.length; i++)
            System.out.print(answer[i] + " ");
        System.out.println();

        /*testcase2*/
        answer = sol.solution(N2, stages2);
        for (int i = 0; i < answer.length; i++)
            System.out.print(answer[i] + " ");
    }
}
