import java.util.ArrayList;
import java.util.Arrays;

enum Hand {
    LEFT, RIGHT
}

public class Solution {
    public String solution(int[] numbers, String hand) {

        StringBuffer answer = new StringBuffer();
        String[] currentPosition = {"*", "#"};

        int leftDistance = 0;
        int rightDistance = 0;
        String[] leftNum = {"1", "4", "7", "*"}; //무조건 왼손 사용하는 숫자들
        String[] rightNum = {"3", "6", "9", "#"}; //무조건 오른손 사용하는 숫자들
        ArrayList<String> leftNumber = new ArrayList<>(Arrays.asList(leftNum));
        ArrayList<String> rightNumber = new ArrayList<>(Arrays.asList(rightNum));
        String handUsed = ""; // 현재 숫자 누르기 위해 사용한 손

        for (int number : numbers) {
                //1, 4, 7, *인 경우
            if (leftNumber.contains(Integer.toString(number))) {
                handUsed = "left";
                //3, 6, 9, #인 경우
            } else if (rightNumber.contains(Integer.toString(number))) {
                handUsed = "right";
                //2, 5, 8, 0인 경우
                //이 경우 별도 왼쪽 오른쪽 거리 계산 및 비교 필요
            } else {
                leftDistance = distanceCalculate(number, currentPosition[Hand.LEFT.ordinal()]);
                rightDistance = distanceCalculate(number, currentPosition[Hand.RIGHT.ordinal()]);

                if (leftDistance > rightDistance) {
                    handUsed = "right";
                } else if (leftDistance < rightDistance) {
                    handUsed = "left";
                } else {
                    handUsed = hand.equals("right") ? "right" : "hand";
                }
            }
                /*왼손 사용한 경우*/
            if(handUsed.equals("left")){
                answer.append("L");
                currentPosition[Hand.LEFT.ordinal()] = Integer.toString(number);
                /*오른손 사용한 경우*/
            }else{
                answer.append("R");
                currentPosition[Hand.RIGHT.ordinal()] = Integer.toString(number);
            }
        }
        return answer.toString();
    }

    /*왼손 또는 오른손 사용시 거리 측정하는 함수*/
    public int distanceCalculate(int num, String currentPosition) {
        int distance = 0;
        int[] index1;
        int[] index2;
        String[][] keypad =
                {{"1", "2", "3"},
                        {"4", "5", "6"},
                        {"7", "8", "9"},
                        {"*", "0", "#"}};
        String number = Integer.toString(num);
        index1 = search(keypad, number);
        index2 = search(keypad, currentPosition);
        distance = Math.abs(index1[0] - index2[0]) + Math.abs(index1[1] - index2[1]);

        return distance;
    }

    /*2차원 배열 탐색 함수*/
    public int[] search(String[][] keypad, String number) {
        int[] index = {0, 0};

        for (int i = 0; i < keypad.length; i++) {
            for (int j = 0; j < keypad[i].length; j++) {
                if (keypad[i][j].equals(number)) {
                    index[0] = i;
                    index[1] = j;
                }
            }
        }

        return index;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] number1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        int[] number2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        int[] number3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        System.out.println(sol.solution(number1, "right"));
        System.out.println(sol.solution(number2, "left"));
        System.out.println(sol.solution(number3, "right"));

    }
}
