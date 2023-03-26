import sys
from heapq import heappop, heappush, heapify

n, m = map(int, sys.stdin.readline().split())
heap = list(map(int, sys.stdin.readline().split()))
heapify(heap)

for i in range(m):
    t = heappop(heap) + heappop(heap)
    heappush(heap, t)
    heappush(heap, t)

print(sum(heap))