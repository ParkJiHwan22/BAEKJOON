# 1743 음식물 피하기
# 문제
# 코레스코 콘도미니엄 8층은 학생들이 3끼의 식사를 해결하는 공간이다. 그러나 몇몇 비양심적인 학생들의 만행으로 음식물이 통로 중간 중간에 떨어져 있다. 이러한 음식물들은 근처에 
# 있는 것끼리 뭉치게 돼서 큰 음식물 쓰레기가 된다. 

# 이 문제를 출제한 선생님은 개인적으로 이러한 음식물을 실내화에 묻히는 것을 정말 진정으로 싫어한다. 참고로 우리가 구해야 할 답은 이 문제를 낸 조교를 맞추는 것이 아니다. 

# 통로에 떨어진 음식물을 피해가기란 쉬운 일이 아니다. 따라서 선생님은 떨어진 음식물 중에 제일 큰 음식물만은 피해 가려고 한다. 

# 선생님을 도와 제일 큰 음식물의 크기를 구해서 “10ra"를 외치지 않게 도와주자.

# 입력
# 첫째 줄에 통로의 세로 길이 N(1 ≤ N ≤ 100)과 가로 길이 M(1 ≤ M ≤ 100) 그리고 음식물 쓰레기의 개수 K(1 ≤ K ≤ N×M)이 주어진다.  그리고 다음 K개의 줄에 음식물이 떨어진 좌표 
# (r, c)가 주어진다.

# 좌표 (r, c)의 r은 위에서부터, c는 왼쪽에서부터가 기준이다. 입력으로 주어지는 좌표는 중복되지 않는다.

# 출력
# 첫째 줄에 음식물 중 가장 큰 음식물의 크기를 출력하라.

import sys

n, m, k = map(int, sys.stdin.readline().split())

dy = [0, -1, 0, 1, 0]
dx = [1, 0, -1, 0, 0]
trash = [[0]*m for _ in range(n)]
trash_max = 0
cnt = 0

for _ in range(k):
    r, c = map(int, sys.stdin.readline().split())
    trash[r-1][c-1] = 1

for i in range(n):
    for j in range(m):
        if trash[i][j] == 1:
            stack = []
            stack.append(j)
            stack.append(i)
            cnt = 0
            
            while stack:
                y = stack.pop()
                x = stack.pop()

                for dir in range(5):
                    if 0 <= y + dy[dir] < n and 0 <= x + dx[dir] < m:
                        if trash[y + dy[dir]][x + dx[dir]] == 1:
                            trash[y + dy[dir]][x + dx[dir]] = 2
                            stack.append(x + dx[dir])
                            stack.append(y + dy[dir])
                            cnt += 1 # 몇 콤보인지 세는 것과 같은 문제
                            if trash_max <= cnt:
                                trash_max = cnt

print(trash_max)

# 예제 입력 1 
# 3 4 5
# 3 2
# 2 2
# 3 1
# 2 3
# 1 1
# 예제 출력 1 
# 4