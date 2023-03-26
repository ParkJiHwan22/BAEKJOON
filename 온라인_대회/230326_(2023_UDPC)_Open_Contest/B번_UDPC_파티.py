vote = input()
DP, UC = 0, 0

for i in vote:
    if i in ('D', 'P'):
        DP += 1
    else:
        UC += 1


if UC == 1 and DP == 1:
    print('DP')
elif DP == 0:
    print('U')
elif UC >= DP:
    print('UDP')
elif DP % 2 == 1:
    if (DP + 1) // 2 >= UC:
        print('DP')
    else:
        print('UDP')
elif DP % 2 == 0:
    if DP // 2 >= UC:
        print('DP')
    else:
        print('UDP')
