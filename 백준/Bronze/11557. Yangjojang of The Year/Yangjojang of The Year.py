N = int(input())

for i in range(N):
    S = int(input())
    school = [list(input().split()) for _ in range(S)]
    tmp = 0

    for j in range(S):
        if int(school[j][1]) >= tmp:
            tmp = int(school[j][1])
            result = school[j][0]
    
    print(result)