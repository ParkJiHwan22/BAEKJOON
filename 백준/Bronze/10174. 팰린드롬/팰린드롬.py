from collections import deque
import sys
input = sys.stdin.readline

n = int(input())

for i in range(n):
    word = input().upper().strip()
    err = 0
    
    q = deque(word)
    
    while len(q) > 1:
        if q.popleft() == q.pop():
            continue
        
        else:
            err += 1
            break
        
    if err:
        print('No')
    else:
        print('Yes')