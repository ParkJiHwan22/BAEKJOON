T = int(input())
for _ in range(T):
    n, m = map(int, input().split())
    eat = sorted(list(map(int, input().split())))
    eaten = sorted(list(map(int, input().split())))

    cnt = 0
    for x in eat:
        start, end = 0, m-1
        k = -1

        while start <= end:
            mid = (start + end) // 2

            if x <= eaten[mid]:
                end = mid - 1

            elif x > eaten[mid]:
                k = mid
                start = mid + 1
        
        if k >= 0:
            cnt += k + 1 
    print(cnt)