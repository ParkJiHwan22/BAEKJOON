import sys
from collections import deque

n, l = map(int, sys.stdin.readline().split())
alcohol = list(map(int, sys.stdin.readline().split()))
cnt, drunken = 0, 0
heap = deque()


for i in range(n):
    if len(heap) < l:
        heap.append(alcohol[i])
        drunken += alcohol[i]
        
    elif len(heap) == l:
        heap.append(alcohol[i])
        drunken += alcohol[i]
        drunken -= heap.popleft()
   
    if 129 <= drunken <= 138:
        cnt += 1
    
print(cnt)