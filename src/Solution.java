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
        String[] leftNum = {"1", "4", "7", "*"};
        String[] rightNum = {"3", "6", "9", "#"};
        ArrayList<String> leftNumber = new ArrayList<>(Arrays.asList(leftNum));
        ArrayList<String> rightNumber = new ArrayList<>(Arrays.asList(rightNum));

        for (int number : numbers) {
            if (leftNumber.contains(Integer.toString(number))) {
                answer.append("L");
                currentPosition[Hand.LEFT.ordinal()] = Integer.toString(number);
            } else if (rightNumber.contains(Integer.toString(number))) {
                answer.append("R");
                currentPosition[Hand.RIGHT.ordinal()] = Integer.toString(number);
            } else {
                leftDistance = distanceCalculate(number, currentPosition[Hand.LEFT.ordinal()]);
                rightDistance = distanceCalculate(number, currentPosition[Hand.RIGHT.ordinal()]);
                //System.out.printf("leftDistance: %d, rightDistance: %d \n", leftDistance, rightDistance);
                if (leftDistance > rightDistance) {
                    answer.append("R");
                    currentPosition[Hand.RIGHT.ordinal()] = Integer.toString(number);
                } else if (leftDistance < rightDistance) {
                    answer.append("L");
                    currentPosition[Hand.LEFT.ordinal()] = Integer.toString(number);
                } else {
                    if (hand.equals("right")) {
                        answer.append("R");
                        currentPosition[Hand.RIGHT.ordinal()] = Integer.toString(number);
                    } else if (hand.equals("left")) {
                        answer.append("L");
                        currentPosition[Hand.LEFT.ordinal()] = Integer.toString(number);
                    }
                }
            }
        }
        String answerString = answer.toString();
        return answerString;
    }

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
