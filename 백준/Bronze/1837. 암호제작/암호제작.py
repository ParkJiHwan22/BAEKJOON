P, K = map(int, input().split())
bad_number = K

for i in range(2, K):
    if P % i == 0:
        if bad_number > i:
            bad_number = i
if bad_number != K:
    print('BAD', bad_number)
else:
    print('GOOD')