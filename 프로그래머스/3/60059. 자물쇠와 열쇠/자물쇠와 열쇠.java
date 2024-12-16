class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;
        
        // 자물쇠를 확장한 배열 생성 (key를 이동시키며 확인하기 위함)
        int len = N + 2 * (M - 1);
        int[][] expandedLock = new int[len][len];
        
        // 확장된 배열 중앙에 자물쇠 배치
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                expandedLock[i + M - 1][j + M - 1] = lock[i][j];
            }
        }
        
        // 4방향 회전에 대해 검사
        for(int rot = 0; rot < 4; rot++) {
            key = rotate(key); // 키 회전
            
            // 이동하면서 모든 경우 확인
            for(int i = 0; i < len - M + 1; i++) {
                for(int j = 0; j < len - M + 1; j++) {
                    // 키를 넣어보기
                    if(tryUnlock(i, j, key, expandedLock, N, M)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    // 키를 시계 방향으로 90도 회전
    private int[][] rotate(int[][] arr) {
        int M = arr.length;
        int[][] rotated = new int[M][M];
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < M; j++) {
                rotated[j][M - 1 - i] = arr[i][j];
            }
        }
        
        return rotated;
    }
    
    // 자물쇠가 열리는지 확인
    private boolean tryUnlock(int startX, int startY, int[][] key, int[][] expandedLock, int N, int M) {
        int[][] temp = new int[expandedLock.length][expandedLock.length];
        
        // 배열 복사
        for(int i = 0; i < expandedLock.length; i++) {
            temp[i] = expandedLock[i].clone();
        }
        
        // 키 넣어보기
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < M; j++) {
                temp[startX + i][startY + j] += key[i][j];
            }
        }
        
        // 자물쇠 영역이 모두 1인지 확인
        for(int i = M - 1; i < M - 1 + N; i++) {
            for(int j = M - 1; j < M - 1 + N; j++) {
                if(temp[i][j] != 1) return false;
            }
        }
        
        return true;
    }
}