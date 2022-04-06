import java.util.ArrayList;

public class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        boolean isPrimeNumber = false;
        ArrayList<Integer> arrayList = new ArrayList<>();

        /*조합 만들기*/
        combination(arrayList, nums);
        System.out.println(arrayList);
        /*조합 중 소수 찾을 시 answer 증가*/
        for(int i = 0; i < arrayList.size() ; i++){
            isPrimeNumber = false;
            for(int j = 2 ; j <= Math.sqrt(arrayList.get(i)) ; j++){
                if((arrayList.get(i) % j == 0)) {
                    isPrimeNumber = false;
                    break;
                }
                else
                    isPrimeNumber = true;
            }
            answer = (isPrimeNumber == true) ? ++answer : answer;
        }

        return answer;
    }

    void combination (ArrayList<Integer> arrayList, int[] nums){
        int[] window = {0, 1};
        Integer sum;
        while(window[1] < nums.length){
            for(int i = window[1]+1 ; i < nums.length ; i++ ){
                sum = nums[window[0]] + nums[window[1]] + nums[i] ;
                if(!arrayList.contains(sum))
                    arrayList.add(sum);
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
        System.out.println(sol.solution(testcase2));

    }

}
