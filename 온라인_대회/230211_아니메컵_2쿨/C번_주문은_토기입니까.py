import sys

n, m = map(int, sys.stdin.readline().split())
t = list(map(int, sys.stdin.readline().split()))

dish = 0
coffee = 0
order = 0
fail = 0

for i in range(t[-1]+1):
    if i in t:
        coffee -= 1
        if coffee < 0:
            fail += 1
            break

    elif (i + m) in t:
        order += 1
        if dish > 0:
            coffee += 1
            dish -= 1
        else:
            dish += 1

    elif order > 0:
        if dish > 0:
            coffee += 1
            dish -= 1
        else:
            dish += 1
    else:
        dish += 1

if fail > 0:
    print('fail')
else:
    print('success')