import sys
import heapq

N = int(sys.stdin.readline())
heap = []

for i in range(N):
    num_list = list(map(int, sys.stdin.readline().split()))
    for j in range(N):
        heapq.heappush(heap, num_list[j])
        if i != 0:
            heapq.heappop(heap)
    num_list.clear()

print(heapq.heappop(heap))
