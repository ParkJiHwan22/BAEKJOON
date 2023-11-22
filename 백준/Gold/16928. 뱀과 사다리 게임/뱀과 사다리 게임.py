import heapq
import sys
input = sys.stdin.readline

x, y = map(int, input().split())
ladder = {}
snake = {}

for _ in range(x+y):
    a, b = map(int, input().split())
    
    if a < b:
        ladder[a] = b
    else:
        snake[a] = b

complete = 0

heap = []
heapq.heapify(heap)
heapq.heappush(heap, [0, 1])

while complete == 0:
    cnt, location = heapq.heappop(heap)
    
    if location >= 94:
        complete = 1
        print(cnt + 1)

    else:
        for i in range(1, 7):
            if location + i in ladder:
                heapq.heappush(heap, [cnt + 1, ladder[location + i]])
                        
        for j in range(1, 7):
            if location + j in snake:
                heapq.heappush(heap, [cnt + 1, snake[location + j]])
        
        switch = 0
        for k in range(6, 0, -1):
            if location + k not in snake and location + k not in ladder and switch == 0:
                switch = 1     
                heapq.heappush(heap, [cnt + 1, location + k])