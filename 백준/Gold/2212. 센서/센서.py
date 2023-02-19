import sys

n = int(sys.stdin.readline())
k = int(sys.stdin.readline())
sensor = list(map(int, sys.stdin.readline().split()))

sensor = sorted(sensor)

gap_list = []
for i in range(0, len(sensor) - 1):
    gap_list.append(sensor[i+1] - sensor[i])

gap_list = sorted(gap_list, reverse=True)
gap = 0


if len(gap_list) < k:
    print(0)
else:
    for j in range(k-1):
        gap += gap_list[j]

    print((sensor[-1] - sensor[0]) - gap)