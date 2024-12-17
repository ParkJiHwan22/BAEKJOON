class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        String[] vl = video_len.split(":");
        String[] p = pos.split(":");
        String[] ops = op_start.split(":");
        String[] ope = op_end.split(":");
        
        int videoLen = Integer.parseInt(vl[0]) * 60 + Integer.parseInt(vl[1]);
        int position = Integer.parseInt(p[0]) * 60 + Integer.parseInt(p[1]);
        int opStart = Integer.parseInt(ops[0]) * 60 + Integer.parseInt(ops[1]);
        int opEnd = Integer.parseInt(ope[0]) * 60 + Integer.parseInt(ope[1]);
        
        for (String cmd : commands) {
            if (position >= opStart && position <= opEnd) position = opEnd;

            if (cmd.charAt(0) == 'n') {
                if (position + 10 > videoLen) position = videoLen;
                else if (position + 10 >= opStart && position + 10 <= opEnd) position = opEnd;
                else position += 10;
            } else if (cmd.charAt(0) == 'p') {
                if (position < 10) position = 0;
                else if (position - 10 >= opStart && position - 10 <= opEnd) position = opEnd;
                else position -= 10;
            }
        }
        
        answer = String.format("%02d:%02d", position/60, position%60);
        
        return answer;
    }
}