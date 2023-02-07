# 11724 연결 요소의 개수
# 문제
# 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

# 입력
# 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 
# u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

# 출력
# 첫째 줄에 연결 요소의 개수를 출력한다.

# import sys

# n, m = map(int, sys.stdin.readline().split())
# graph = [[] for _ in range(n+1)]

# for i in range(m):
#     u, v = map(int, sys.stdin.readline().split())
#     graph[u].append(v)
#     graph[v].append(u)

# visited = [0]*(n + 1)
# stack = []
# cnt = 0

# for x in range(1, n+1):
#     if visited[x] != 1:
#         visited[x] = 1
#         cnt += 1
#         stack.append(x)

#         while stack:
#             y = stack.pop()
#             for z in graph[y]:
#                 if visited[z] == 0:
#                     visited[z] = 1
#                     stack.append(z)

# print(cnt)

#==================================================

import sys
sys.setrecursionlimit(5000)

def dfs(start, depth): # dfs로 그래프를 탐색한다.
    visited[start] = True # 해당 노드 방문체크 한다.
    for i in graph[start]: # 해당 시작점을 기준으로 계속해서 dfs로 그래프를 탐색한다.
        if not visited[i]:
            dfs(i, depth + 1)

n, m = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    u, v = map(int, sys.stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)

visited = [False] * (1 + n) # 방문처리
count = 0  # 컴포넌트 그래프 개수 저장

for i in range(1, n + 1): # 1 ~ N 번 노드를 각각돌면서
    if not visited[i]:  # 만약 i 번째 노드를 방문하지 않았다면
        if not graph[i]:  # 만약 해당 정점이 연결된 그래프가 없다면
            count += 1  # 개수를 + 1
            visited[i] = True  # 방문 처리
        else:  # 연결된 그래프가 있다면
            dfs(i, 0)  # dfs 탐색을 돈다.
            count += 1  # 개수를 +1

print(count)
    


# 예제 입력 1 
# 6 5
# 1 2
# 2 5
# 5 1
# 3 4
# 4 6
# 예제 출력 1 
# 2

# 예제 입력 2 
# 6 8
# 1 2
# 2 5
# 5 1
# 3 4
# 4 6
# 5 4
# 2 4
# 2 3
# 예제 출력 2 
# 1