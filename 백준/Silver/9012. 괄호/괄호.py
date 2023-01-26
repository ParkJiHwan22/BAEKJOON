import sys

T = int(sys.stdin.readline())


for i in range(T):
    VPS = sys.stdin.readline()
    result = []
    cnt = 0
    for i in VPS:
        if i == '(':
            result.append(i)
        elif i == ')':
            if result == []:
                cnt += 1
            else:
                result.pop()

    if cnt == 0:
        if result == []:
            print('YES')
        else:
            print('NO')
    else:
        print('NO')
