from heapq import heappop, heappush
import sys
input = sys.stdin.readline

n = int(input())
road = list(map(int, input().split()))
oil = list(map(int, input().split()))

total, y = 0, -1

while y != 1 and y != 0:
    heap = []
    for i in oil[:y]:
        heappush(heap, i)
    x = heappop(heap)
    y = oil.index(x)
    for j in road[y:]:
        total += j * x

if y == 1:
    total += road[0] * oil[0]

print(total)