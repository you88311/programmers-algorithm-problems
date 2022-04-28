
import java.util.ArrayList;

public class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        boolean isPrimeNumber;
        ArrayList<Integer> arrayList = new ArrayList<>();

        /*조합 만들기*/
        combination(arrayList, nums);
        /*조합 중 소수 찾을 시 answer 증가*/
        for (int i = 0; i < arrayList.size(); i++) {
            isPrimeNumber = true;
            for (int j = 2; j <= Math.sqrt(arrayList.get(i)); j++) {
                if ((arrayList.get(i) % j == 0)) {
                    isPrimeNumber = false;
                    break;
                }
            }
            answer += (isPrimeNumber) ? 1 : 0;
        }
        return answer;
    }

    void combination(ArrayList<Integer> arrayList, int[] nums) {
        Integer sum;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    arrayList.add(sum);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] testcase1 = {1, 2, 3, 4,};
        int[] testcase2 = {1, 2, 7, 6, 4};
        Solution sol = new Solution();
        System.out.println(sol.solution(testcase1));
        System.out.println(sol.solution(testcase2));

    }

}
