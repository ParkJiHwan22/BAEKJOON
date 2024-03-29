from collections import deque

n = int(input())
sea = [list(map(int, input().split())) for _ in range(n)]
level = 2
fish_eaten = 0
time = 0

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 아기 상어 위치 찾기
for i in range(n):
    for j in range(n):
        if sea[i][j] == 9:
            start_x, start_y = j, i
            sea[i][j] = 0  # 아기 상어 위치를 0으로 변경

while True:
    queue = deque([(start_x, start_y, 0)])
    visited = [[0] * n for _ in range(n)]
    visited[start_y][start_x] = 1
    fishes = []  # 잡아먹힐 물고기들
    before_time = 0
    
    while queue:
        x, y, t = queue.popleft()

        if fishes and before_t != t:
            break
            
        for dir in range(4):
            new_x = x + dx[dir]
            new_y = y + dy[dir]

            if 0 <= new_x < n and 0 <= new_y < n and not visited[new_y][new_x]: # 방문 여부 체크
                visited[new_y][new_x] = True
                
                if sea[new_y][new_x] == 0 or sea[new_y][new_x] == level: # 먹을 수 없으나 지나가는 경우
                    queue.append((new_x, new_y, t + 1))
                elif 0 < sea[new_y][new_x] < level: # 먹을 수 있는 경우
                    fishes.append((new_x, new_y, t + 1))
                    
        before_t = t

    # 잡아먹힐 물고기가 없다면 식을 종료
    if not fishes:
        break

    # 물고기를 거리, 행, 열 순으로 정렬
    fishes = sorted(fishes, key=lambda x: (x[2], x[1], x[0]))
    fish = fishes[0] # 거리가 가장 가깝고 행, 열 기준으로 가장 위에 있는 물고기
    sea[fish[1]][fish[0]] = 0  # 결국 잡아먹힌 물고기
    
    fish_eaten += 1
    if fish_eaten == level:
        level += 1
        fish_eaten = 0

    time += fish[2]
    start_x, start_y = fish[0], fish[1]

print(time)