
public class Solution {
    public String solution(String new_id) {
        String answer = new_id;
        /*1단계 대문자 -> 소문자*/
        answer = answer.toLowerCase();

        /*2단계 소문자, 숫자 , '-', '_', '.' 제외 모든 문자 제거*/
        /*
        for (int i = 0; i < new_id.length(); i++) {
            if (String.valueOf(new_id.charAt(i)).matches("[a-z0-9-_.]"))
                sb.append(new_id.charAt(i));
        }
        answer = sb.toString();
        */

        answer = answer.replaceAll("[^a-z0-9-_.]", "");

        /*3단계  연속 ..은 하나의 .만 저장*/
        while (answer.contains(".."))
            answer = answer.replaceAll("\\.\\.", "\\.");

        /*4단계 처음이나 끝이 '.'인 경우 '.'제거*/
        /*
        if ((answer.length() != 0) && answer.charAt(0) == '.') {
            if (answer.length() >= 2)
                answer = answer.substring(1);
            else
                answer = "";
        }
        if ((answer.length() != 0) && answer.charAt(answer.length() - 1) == '.') {
            if (answer.length() >= 2)
                answer = answer.substring(0, answer.length() - 1);
            else
                answer = "";
        }
        */
        answer = answer.replaceAll("^[.]|[.]$", "");

        /*5단계 빈문자열이면 "a"추가*/
        if (answer.length() == 0)
            answer = "a";

        /*6단계 16자 이상이면 15자 까지만 저장 + 마지막 문자가 "."이면 제거*/
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            while (answer.charAt(answer.length() - 1) == '.') {
                answer = answer.substring(0, answer.length() - 1);
            }
        }

        /*7단계 길이가 2자 이하면 길이가 3이 될때까지 마지막 문자 붙여넣기*/
        if (answer.length() <= 2) {
            while (answer.length() != 3) {
                char lastChar = answer.charAt(answer.length() - 1);
                answer = answer.concat(String.valueOf(lastChar));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String new_id1 = "...!@BaT#*..y.abcdefghijklm.";
        String new_id2 = "z-+.^.";
        String new_id3 = "=.=";
        String new_id4 = "123_.def";
        String new_id5 = "abcdefghijklmn.p";
        System.out.println(sol.solution(new_id1));
        System.out.println(sol.solution(new_id2));
        System.out.println(sol.solution(new_id3));
        System.out.println(sol.solution(new_id4));
        System.out.println(sol.solution(new_id5));
    }

}
