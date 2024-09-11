import java.util.ArrayList;

class Solution {
    public static ArrayList<ArrayList<Integer>> link;
    public static int[][] dp = new int[300001][2];

    public int solution(int[] sales, int[][] links) {
        link = new ArrayList<>();

        // 링크 초기화
        for (int i = 0; i < sales.length + 1; i++) {
            link.add(new ArrayList<>());
        }

        // 링크 정보 추가
        for (int i = 0; i < links.length; i++) {
            int a = links[i][0];
            int b = links[i][1];
            link.get(a).add(b);
        }

        // DFS 시작
        dfs(sales, 1);

        // 결과 계산
        int answer = Math.min(dp[1][0], dp[1][1]);
        return answer;
    }

    // DFS 함수
    public static void dfs(int[] sales, int idx) {
        dp[idx][0] = 0;
        dp[idx][1] = sales[idx - 1];

        if (link.get(idx).size() == 0) return;

        int extra = (int) 1e9;
        for (int child : link.get(idx)) {
            dfs(sales, child);

            if (dp[child][0] < dp[child][1]) {
                dp[idx][0] += dp[child][0];
                dp[idx][1] += dp[child][0];

                extra = Math.min(extra, dp[child][1] - dp[child][0]);
            } else {
                dp[idx][0] += dp[child][1];
                dp[idx][1] += dp[child][1];

                extra = 0;
            }
        }

        dp[idx][0] += extra;
        return;
    }
}
