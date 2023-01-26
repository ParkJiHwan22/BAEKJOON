from collections import deque

T = int(input())

for i in range(T):
    N, M = map(int, input().split())
    num_list = deque(map(int, input().split()))
    
    k = max(0, N - M - 1)
    rank_f = 0
    rank_b = 0

    while True:
        
        rf = 0
        rb = 0

        for i in range(M):
            if num_list[0] == max(num_list):
                num_list.popleft()
                rank_f += 1
                rf += 1
            else:
                num_list.append(num_list[0])
                num_list.popleft()
                
        if num_list[0] == max(num_list):
            num_list.popleft()
            rank_f += 1
            rf += 1
            break
        else:
            num_list.append(num_list[0])
            num_list.popleft()   

        for j in range(k):
            if num_list[0] == max(num_list):
                num_list.popleft()
                rank_b += 1
                rb += 1
            else:
                num_list.append(num_list[0])
                num_list.popleft()

        M = max(0, M - rf)        
        k = max(0, k - rb)
        

    print(rank_f + rank_b)