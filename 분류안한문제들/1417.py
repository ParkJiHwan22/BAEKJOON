from heapq import heappush, heappop

n = int(input())
c = [int(input()) for _ in range(n)]
x = []
cnt = 0

if len(c) == 1:
    print(cnt)
else:
    dasom = c.pop(0)
    
    while c:
        heappush(x, -heappop(c))
    
    while True:
        if dasom > -min(x):
            break
        else:
            heappush(x, heappop(x)+1)
            dasom += 1
            cnt += 1
            
    print(cnt)