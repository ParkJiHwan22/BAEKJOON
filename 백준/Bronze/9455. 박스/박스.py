T = int(input())

for _ in range(T):
    m, n = map(int, input().split())
    num_list = [list(map(int, input().split())) for _ in range(m)]
    
    sum = 0
    for i in range(n):
        cnt = 0
        for j in range(m):
            if num_list[m-j-1][i] == 1:
                sum += j - cnt
                cnt += 1

    print(sum)