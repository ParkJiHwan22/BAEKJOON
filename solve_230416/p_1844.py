# import sys
# from collections import deque

# def bfs(queue:deque, graph, answer):
#     x = queue.popleft()
#     y = queue.popleft()

#     for v in range(4):
#         if 0 <= x + dx[v] < 5 and 0 <= y + dy[v] < 5:
#             if graph[x + dx[v]][y + dy[v]] == 1:
#                 if [x + dx[v]] == 4 and [y + dy[v]] == 4:
#                     print(answer)
#                     break
#                 else:
#                     queue.append(x + dx[v])
#                     queue.append(y + dy[v])
                
#     graph[x + dx[v]][y + dy[v]] = 0
#     answer += 1

# graph = [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]
# dx = [1, 0, -1, 0]
# dy = [0, -1, 0, 1]
# queue = deque()
# answer = 0
# queue.append(0)
# queue.append(0)

# bfs(queue, graph, answer)

import sys
from collections import deque

def bfs(queue:deque, graph, steps):
    dx = [1, 0, -1, 0]
    dy = [0, -1, 0, 1]
    while queue:
        x = queue.popleft()
        y = queue.popleft()

        for v in range(4):
            if 0 <= x + dx[v] < 5 and 0 <= y + dy[v] < 5:
                if graph[x + dx[v]][y + dy[v]] == 1:
                    if x + dx[v] == 4 and y + dy[v] == 4:
                        print(steps+1)
                        return
                    else:
                        queue.append(x + dx[v])
                        queue.append(y + dy[v])
                        graph[x + dx[v]][y + dy[v]] = 0

        steps += 1

graph = [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]
queue = deque()
queue.append(0)
queue.append(0)

bfs(queue, graph, 0)