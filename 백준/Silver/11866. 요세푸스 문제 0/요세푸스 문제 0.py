from collections import deque

n, k = map(int, input().split())
yosepus = deque()
for i in range(n):
    yosepus.append(i+1)

print('<', end = '')
while len(yosepus) > 1:
    yosepus.rotate(-k)
    print(yosepus.pop(), end = ', ')

print(f'{yosepus.pop()}>')