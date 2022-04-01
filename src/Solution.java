enum handPosition{
    LEFT, RIGHT
}

public class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuffer answer = new StringBuffer();
        int[] currentPosition = {'*','#'};
        int leftDistance = 0;
        int rightDistance = 0;

        for (int tmp : currentPosition)
            System.out.println(tmp);

        for(int i = 0 ; i < numbers.length ; i++){
            if(numbers[i]% 3 == 1){
                currentPosition[handPosition.LEFT.ordinal()] = numbers[i];
                answer.append("L");
            }else if(numbers[i]% 3 == 0) {
                currentPosition[handPosition.RIGHT.ordinal()] = numbers[i];
                answer.append("R");
            }else{
                leftDistance = 

            }



        }


        return answer.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String hand = "right";
        int[] number1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};

        System.out.println(sol.solution(number1, hand));
    }
}
