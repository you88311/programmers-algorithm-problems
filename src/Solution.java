import java.util.ArrayList;

public class Solution {
    public String solution(String new_id) {
        String answer = "";
        /*1단계 대문자 -> 소문자*/
        new_id = new_id.toLowerCase();
        /*2단계*/
        System.out.println(new_id);

        return answer;
    }
    public String secondStep(String new_id){
        String answer = "";
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(new_id);

        for(int i = 0; i < arrayList.size() ; i++){
            if(arrayList.get(i) != "")
        }

        return answer;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        String new_id =  "...!@BaT#*..y.abcdefghijklm";

        System.out.println(sol.solution(new_id));
    }
}
