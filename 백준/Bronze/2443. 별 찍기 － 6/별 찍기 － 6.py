N = int(input())

star = ['*'*(2*N-2*i-1) for i in range(N)]
for i in range(N):
    star = '*'*(2*N-2*i-1)
    print(' '*i, end = '')
    print(star, sep ='\n')