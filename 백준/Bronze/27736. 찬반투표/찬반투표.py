n = int(input())
num_lst = list(map(int, input().split()))
invalid = 0
total = 0
for i in num_lst:
    if i == 0:
        invalid += 1
    
    else:
        total += i

if invalid != 0:
    if len(num_lst) / invalid <= 2:
        print('INVALID')
        
    elif total > 0:
        print('APPROVED')

    else:
        print('REJECTED')

else:
    if total > 0:
        print('APPROVED')

    else:
        print('REJECTED')