M = int(input())
N = int(input())
lst = []


for i in range(M, N+1):
    cnt = 0
    if i == 1:
        cnt +=1
    elif i == 2:
        True

    for j in range(2, i):
        if i % j == 0:
            cnt += 1
        
    if cnt == 0:
        lst.append(i)

if lst == []:
    print(-1)
else:    
    print(sum(lst), min(lst), sep='\n')