# 2210 숫자판 점프 다국어

# 문제
# 5×5 크기의 숫자판이 있다. 각각의 칸에는 숫자(digit, 0부터 9까지)가 적혀 있다. 
# 이 숫자판의 임의의 위치에서 시작해서, 인접해 있는 네 방향으로 다섯 번 이동하면서, 
# 각 칸에 적혀있는 숫자를 차례로 붙이면 6자리의 수가 된다. 이동을 할 때에는 한 번 
# 거쳤던 칸을 다시 거쳐도 되며, 0으로 시작하는 000123과 같은 수로 만들 수 있다.

# 숫자판이 주어졌을 때, 만들 수 있는 서로 다른 여섯 자리의 수들의 개수를 구하는 
# 프로그램을 작성하시오.

# 입력
# 다섯 개의 줄에 다섯 개의 정수로 숫자판이 주어진다.

# 출력
# 첫째 줄에 만들 수 있는 수들의 개수를 출력한다.

# import sys
# sys.setrecursionlimit(10 ** 6)  # 재귀 허용 깊이를 수동으로 늘려주는 코드


# # DFS로 특정 노드를 방문하고 연결된 모든 노드들도 방문
# def dfs(x, y, number):
#     number += graph[x][y]

#     # 숫자 길이가 6이면 멈추고 똑같은 숫자의 합이 있는지 결과 리스트에서 확인
#     if len(number) == 6:
#         if number not in result:
#             result.append(number)
#         return

#     # 좌/우/위/아래 방향의 좌표를 탐색
#     for i in range(4):
#         a = x + dx[i]
#         b = y + dy[i]

#         # 맵 정보를 넘지 않는다면 탐색
#         if 0 <= a < 5 and 0 <= b < 5:
#             dfs(a, b, number)


# # 2차원 맵 정보를 입력
# graph = [list(map(str, sys.stdin.readline().split())) for i in range(5)]
# dy = [0, 0, 1, -1]
# dx = [1, -1, 0, 0]
# result = []

# for i in range(5):
#     for j in range(5):
#         dfs(i, j, "")

# print(len(result))

#=============================================================================

import sys
sys.setrecursionlimit(10 ** 6)

def dfs(x, y, number):
    number += graph[x][y]
    
    if len(number) == 6:
        if number not in result:
            result.append(number)
        return

    for i in range(4):
        a = x + dx[i]
        b = y + dy[i]
        if 0 <= a < 5 and 0 <= b < 5:
            dfs(a, b, number)

graph = [list(map(str, sys.stdin.readline().split())) for i in range(5)]
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
result = []

for i in range(5):
    for j in range(5):
        dfs(i, j, "")

print(len(result))
            
# https://fre2-dom.tistory.com/111
# dfs를 정해진 틀로 생각하지말고 이것저것 시도해보도록 노력해야겠다.
# 딱히 정해진 방식은 없고 상황에 맞게 적용하면 되는 것이니 더 많이 연습하자.
# 최근 슬럼프라고 느낀 부분은 혼자 해결하려했기 때문인 것 같다. 남의 코드를 보며
# 베끼면서 내껄로 만들어서 성장하자.

# 예제 입력 1 
# 1 1 1 1 1
# 1 1 1 1 1
# 1 1 1 1 1
# 1 1 1 2 1
# 1 1 1 1 1
# 예제 출력 1 
# 15