import sys
input = sys.stdin.readline

n = input().strip()
cnt = 0

while int(n) >= 10:
    tmp = 0
    for i in n:
        tmp += int(i)
        n = str(tmp)

    cnt += 1

print(cnt)

if int(n) in [3, 6, 9]:
    print('YES')

else:
    print('NO')