T = int(input())

for _ in range(T):

    k = int(input()) # 몇층?

    n = int(input()) # 몇호?

    people = [ i for i in range(1, n+1)] # keypoint! people을 리스트로 설정

    for __ in range(k): # 층

        for j in range(1,n): # 호

            people[j] += people[j-1] # index를 사용해서 리스트를 계속 바꿈

    print(people[-1]) # 리스트의 맨 마지막 수를 꺼냄