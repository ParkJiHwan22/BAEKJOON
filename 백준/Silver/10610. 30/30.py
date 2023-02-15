import sys

n = str(sys.stdin.readline().rstrip())
tmp = []
ans = ''

if '0' in n:
    for i in n:
        tmp.append(int(i))
    if sum(tmp) % 3 == 0:
        tmp = sorted(tmp, reverse = True)
        for j in tmp:
            ans += str(j)
        print(ans)
        
    else:
        print(-1)
else:
    print(-1)