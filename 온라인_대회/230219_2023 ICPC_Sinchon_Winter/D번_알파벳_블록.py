import sys
from collections import deque

heap = deque()
n = int(sys.stdin.readline())
command = [sys.stdin.readline().split() for _ in range(n)]
recent = []

for i in range(n):
    if command[i][0] == '1':
        heap.append(command[i][1])
        recent.append(1)
    elif command[i][0] == '2':
        heap.appendleft(command[i][1])
        recent.append(2)
    elif command[i][0] == '3':
        if len(heap) > 0:
            k = recent.pop()
            if k == 1:
                heap.pop()
            elif k == 2:
                heap.popleft()
                
if len(heap) == 0:
    print(0)
else:
    for j in heap:
        print(j, end = '')