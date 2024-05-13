N, M = map(int, input().split())

stressList = [x for x in map(int, input().split())]
stress = 0
cnt = 0

for i in stressList:
    stress = max(stress + i, 0)

    if stress >= M:
        cnt += 1

print(cnt)