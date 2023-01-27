import heapq
import sys

N = int(sys.stdin.readline())
heap = []

# 순회하면서 
for _ in range(N):
    n = int(sys.stdin.readline())
    if n != 0:
        heapq.heappush(heap, (abs(n), n))

    # 0이면 heappop
    else:
        if len(heap) != 0:
            print(heapq.heappop(heap)[1])
        else:
            print(0)
