public class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Boolean hasNumber;

        for(int i = 0; i <= 9 ; i++){
            hasNumber = Boolean.FALSE;
            for(int number : numbers){
                if(number == i) {
                    hasNumber = Boolean.TRUE;
                    break;
                }
            }
            if(hasNumber == Boolean.FALSE)
                answer += i;
        }

        return answer;
    }

    public static void main(String[] args){
        int[] testcase1 = {1,2,3,4,6,7,8,0};
        int[] testcase2 = {5,8,4,0,6,7,9};

        Solution sol = new Solution();
        System.out.println(sol.solution(testcase1));
        System.out.println(sol.solution(testcase2));
    }
}

