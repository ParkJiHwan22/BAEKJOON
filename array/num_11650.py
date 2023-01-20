# 11650 좌표 정렬하기
# 문제
# 2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

# 입력
# 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 
# 항상 정수이고, 위치가 같은 두 점은 없다.

# 출력
# 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.

import sys

N = int(input())

point_list = [] # 리스트를 만들고
for i in range(N): # 그 안에 x,y 를 리스트 형식으로 집어 넣음
    [x, y] = map(int, sys.stdin.readline().split())
    point_list.append([x,y])

point_list.sort()

for i in range(N):
    print(*point_list[i])


# 예제 입력 1 
# 5
# 3 4
# 1 1
# 1 -1
# 2 2
# 3 3

# 예제 출력 1 
# 1 -1
# 1 1
# 2 2
# 3 3
# 3 4