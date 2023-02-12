# 2583 영역 구하기
# 문제
# 눈금의 간격이 1인 M × N(M, N ≤ 100)크기의 모눈종이가 있다. 이 모눈종이 위에 눈금에 맞추어 K개의 직사각형을 그릴 때, 이들 K개의 직사각형의 내부를 제외한 나머지 부분이 
# 몇 개의 분리된 영역으로 나누어진다.

# 예를 들어 M=5, N=7 인 모눈종이 위에 <그림 1>과 같이 직사각형 3개를 그렸다면, 그 나머지 영역은 <그림 2>와 같이 3개의 분리된 영역으로 나누어지게 된다.

# <그림 2>와 같이 분리된 세 영역의 넓이는 각각 1, 7, 13이 된다.

# M, N과 K 그리고 K개의 직사각형의 좌표가 주어질 때, K개의 직사각형 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어지는지, 그리고 분리된 각 영역의 넓이가 
# 얼마인지를 구하여 이를 출력하는 프로그램을 작성하시오.

# 입력
# 첫째 줄에 M과 N, 그리고 K가 빈칸을 사이에 두고 차례로 주어진다. M, N, K는 모두 100 이하의 자연수이다. 둘째 줄부터 K개의 줄에는 한 줄에 하나씩 직사각형의 왼쪽 아래 
# 꼭짓점의 x, y좌표값과 오른쪽 위 꼭짓점의 x, y좌표값이 빈칸을 사이에 두고 차례로 주어진다. 모눈종이의 왼쪽 아래 꼭짓점의 좌표는 (0,0)이고, 오른쪽 위 
# 꼭짓점의 좌표는(N,M)이다. 입력되는 K개의 직사각형들이 모눈종이 전체를 채우는 경우는 없다.

# 출력
# 첫째 줄에 분리되어 나누어지는 영역의 개수를 출력한다. 둘째 줄에는 각 영역의 넓이를 오름차순으로 정렬하여 빈칸을 사이에 두고 출력한다.

import sys

m, n, k = map(int, sys.stdin.readline().split())
visited = [[1]*n for _ in range(m)]
dx = [1, 0, -1 ,0, 0]
dy = [0, 1, 0, -1, 0]
cnt = 0
total_area = []

for _ in range(k): # 구역을 나누어준 다음
    rec_list = list(map(int, sys.stdin.readline().split()))

    for i in range(rec_list[1], rec_list[3]):
        for j in range(rec_list[0], rec_list[2]):
            visited[i][j] = 0

for r in range(m): # DFS 실행
    for c in range(n):
        if visited[r][c] == 1:
            stack = []
            stack.append(r)
            stack.append(c)
            cnt += 1
            area = 0

            while stack:
                x = stack.pop()
                y = stack.pop()

                for dir in range(5):
                    if 0 <= x + dx[dir] < n and 0 <= y + dy[dir] < m:
                        if visited[y + dy[dir]][x + dx[dir]] == 1:
                            area += 1
                            visited[y + dy[dir]][x + dx[dir]] = 2
                            stack.append(y + dy[dir])
                            stack.append(x + dx[dir])

            total_area.append(area)

print(cnt)
print(*sorted(total_area))



# 예제 입력 1 
# 5 7 3

# 0 2 4 4
# 1 1 2 5
# 4 0 6 2

# 예제 출력 1 
# 3
# 1 7 13