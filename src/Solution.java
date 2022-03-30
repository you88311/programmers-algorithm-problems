import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> result = new Stack<>();
        ArrayList<Stack<Integer>> board2D = new ArrayList<>();

        for (int j = 0; j < board.length; j++) {
            Stack<Integer> stack = new Stack<>();
            for (int i = board[j].length - 1; i >= 0; i--) {
                stack.push(board[i][j]);
            }
            board2D.add(stack);
        }

        for (int i = 0; i < moves.length; i++) {
            while (!board2D.get(moves[i] - 1).empty()) {
                int element = board2D.get(moves[i] - 1).pop();
                if (element != 0) {
                    if(result.empty() || element != result.peek())
                        result.push(element);
                    else if(element == result.peek()){
                        result.pop();
                        answer +=2;
                    }else {
                        System.out.println("뭔가 잘못됨");
                    }
                    break;
                }
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] board = {{0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 3},
                        {0, 2, 5, 0, 1},
                        {4, 2, 4, 4, 2},
                        {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(sol.solution(board, moves));

    }
}
