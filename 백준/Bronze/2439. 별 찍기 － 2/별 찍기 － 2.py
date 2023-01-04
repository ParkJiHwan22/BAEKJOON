N = int(input())
for i in range(1, N+1):
    k = N - i
    print(k*' ', i*'*', sep='')