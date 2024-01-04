from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
queue = deque([1, 2])
if n < 2:
    print(n)
    
else:
    for _ in range(n - 2):
        queue.append((queue[-1] + queue.popleft()) % 15746)
                
    print(queue[-1])