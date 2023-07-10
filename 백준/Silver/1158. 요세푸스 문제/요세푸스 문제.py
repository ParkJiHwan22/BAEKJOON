from collections import deque

n, k = map(int, input().split())
josephus = deque([i for i in range(1, n+1)])
res = []

while josephus:
    for _ in range(k-1):
        josephus.append(josephus.popleft())

    res.append(josephus.popleft())

print('<', end = '')
for j, num in enumerate(res):
    if j != len(res) - 1:
        print(num, end = ', ')
    else:
        print(num, end = '')
print('>')