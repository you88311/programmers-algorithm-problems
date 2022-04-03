enum handPosition {
    LEFT, RIGHT
}

public class Solution {
    public String solution(int[] numbers, String hand) {

        StringBuffer answer = new StringBuffer();
        int[] currentPosition = {10, 12};

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0)
                numbers[i] = 11;
        }

        /*문제점
        가운데를 누르면 왼쪽손 또는 오른족 손도 가운데로 가있는 것이 currentPosition
        따라서 이후에는 3으로 나눈 나머지가 왼쪽은 1, 오른쪽은 0이 성립하지 않음
         */

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 3 == 1) {
                currentPosition[handPosition.LEFT.ordinal()] = numbers[i];
                answer.append("L");
            } else if (numbers[i] % 3 == 0) {
                currentPosition[handPosition.RIGHT.ordinal()] = numbers[i];
                answer.append("R");
            } else {
                System.out.printf("전: %d, %d \n" , currentPosition[0] , currentPosition[1]);
                currentPosition = distanceCalculate(numbers[i], currentPosition, hand, answer);
                System.out.printf("후: %d, %d \n" , currentPosition[0] , currentPosition[1]);
            }
        }
        return answer.toString();
    }

    public int[] distanceCalculate(int number, int[] currentposition, String hand, StringBuffer answer2) {
        int leftDistance = 1;
        int rightDistance = 1;
        String answer = "";
        int [] tmpPosition = currentposition;

        if()
        while (number != tmpPosition[handPosition.LEFT.ordinal()] + 1) {
            if (number > tmpPosition[handPosition.LEFT.ordinal()] + 1) {
                tmpPosition[handPosition.LEFT.ordinal()] += 3;
            } else {
                tmpPosition[handPosition.LEFT.ordinal()] -= 3;
            }
            leftDistance++;
        }

        while (number != tmpPosition[handPosition.RIGHT.ordinal()] - 1) {
            if (number > tmpPosition[handPosition.RIGHT.ordinal()] - 1) {
                tmpPosition[handPosition.RIGHT.ordinal()] += 3;
            } else {
                tmpPosition[handPosition.RIGHT.ordinal()] -= 3;
            }
            rightDistance++;
        }

        if (rightDistance > leftDistance) {
            answer = "L";
            currentposition[handPosition.LEFT.ordinal()] = number;
        } else if (rightDistance < leftDistance) {
            answer = "R";
            currentposition[handPosition.RIGHT.ordinal()] = number;
        } else {
            if (hand.equals("right")) {
                answer = "R";
                currentposition[handPosition.RIGHT.ordinal()] = number;
            }
            else {
                answer = "L";
                currentposition[handPosition.LEFT.ordinal()] = number;
            }
        }
        answer2.append(answer);

        return currentposition;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        String hand = "right";
        int[] number1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};

        System.out.println(sol.solution(number1, hand));
    }
}
