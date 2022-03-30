/*주석 처리 추가ㅇㅇㅇㅇ*/

public class Solution {
    enum Number{
        zero, one, two, three, four, five, six, seven, eight, nine
    }

    public int solution(String s) {

        for(Number i : Number.values())
            s = s.replaceAll(i.name(), String.valueOf(i.ordinal()));

        int answer = Integer.parseInt(s);
        return answer;
    }

    public static void main(String[] args) {
        String test1 = "one4seveneight";
        String test2 = "23four5six7";
        String test3 = "2three45sixseven";
        String test4 = "123";

        Solution sl = new Solution();

        System.out.println(sl.solution(test1));
        System.out.println(sl.solution(test2));
        System.out.println(sl.solution(test3));
        System.out.println(sl.solution(test4));

    }
}