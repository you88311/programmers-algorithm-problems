
public class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i = 0 ; i < absolutes.length ; i++){
            if(signs[i])
                answer += absolutes[i];
            else
                answer -= absolutes[i];
        }

        return answer;
    }

    public static void main(String[] args){
        int[] testcase1Absolutes = {4, 7 ,12};
        int[] testcase2Absolutes = {1,2,3};
        boolean[] testcase1Signs = {true, false, true};
        boolean[] testcase2Signs = {false,false,true};

        Solution sol = new Solution();
        System.out.println(sol.solution(testcase1Absolutes, testcase1Signs));
        System.out.println(sol.solution(testcase2Absolutes, testcase2Signs));
    }

}
