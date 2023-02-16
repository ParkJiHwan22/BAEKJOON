n, l = map(int, input().split())
hole = list(map(int, input().split()))
hole = sorted(hole)

tape, cnt = 0, 0
for i in range(n):
    if hole[i] > tape:
        tape = hole[i] + l-1
        cnt += 1

print(cnt)