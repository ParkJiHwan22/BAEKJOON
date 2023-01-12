N, M = map(int, input().split())
lst_1 = []
lst_2 = []
lst_3 = []

for i in range(1, N+1):
    lst = list(map(int, input().split()))
    lst_1.append(lst)
for j in range(1, N+1):
    lst = list(map(int, input().split()))
    lst_2.append(lst)

for k in range(N):
    for l in range(M):
        lst_3.append(lst_1[k][l] + lst_2[k][l])

    print(*lst_3, sep=' ')
    lst_3.clear()