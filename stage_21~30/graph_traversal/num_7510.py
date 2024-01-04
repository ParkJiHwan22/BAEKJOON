n = int(input())

for i in range(1, n+1):
    len_list = list(map(int, input().split()))
    len_list = sorted(len_list)
    print('Scenario #%d:' % i)
    if len_list[0]**2 + len_list[1]**2 == len_list[2]**2:
        print('yes')
    else:
        print('no')
        
    print('')
