import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            ArrayList<Integer> tmpArr = new ArrayList<>();

            // tmpArr에 숫자 넣기
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                tmpArr.add(array[j]);
            }

            // sort
            Collections.sort(tmpArr);

            // 꺼내서 answer에 넣기
            answer[i] = tmpArr.get(commands[i][2] - 1);
        }
        
        return answer;
    }
}