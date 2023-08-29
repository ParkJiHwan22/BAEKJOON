from collections import deque

n = int(input())
sea = [list(map(int, input().split())) for _ in range(n)]
level = 2
fish_eaten = 0
time = 0

# Directions: up, down, left, right
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# Find the baby shark's position
for i in range(n):
    for j in range(n):
        if sea[i][j] == 9:
            start_x, start_y = j, i
            sea[i][j] = 0  # Set baby shark's position to empty

while True:
    queue = deque([(start_x, start_y, 0)])
    visited = [[False] * n for _ in range(n)]
    visited[start_y][start_x] = True
    fishes = []  # List of fishes that can be eaten

    while queue:
        x, y, t = queue.popleft()

        for dir in range(4):
            new_x = x + dx[dir]
            new_y = y + dy[dir]

            if 0 <= new_x < n and 0 <= new_y < n and not visited[new_y][new_x]:
                visited[new_y][new_x] = True
                
                if sea[new_y][new_x] == 0 or sea[new_y][new_x] == level:
                    queue.append((new_x, new_y, t + 1))
                elif 0 < sea[new_y][new_x] < level:
                    fishes.append((new_x, new_y, t + 1))

    # If no fish can be eaten, break
    if not fishes:
        break

    # Sort the fishes by distance, row, and column
    fishes.sort(key=lambda x: (x[2], x[1], x[0]))
    fish = fishes[0]
    sea[fish[1]][fish[0]] = 0  # Eat the fish

    fish_eaten += 1
    if fish_eaten == level:
        level += 1
        fish_eaten = 0

    time += fish[2]
    start_x, start_y = fish[0], fish[1]

print(time)