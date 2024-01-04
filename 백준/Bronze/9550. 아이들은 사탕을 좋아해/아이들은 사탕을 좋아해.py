for i in range(int(input())):
    N, K = map(int, input().split())
    li = list(map(int, input().split()))
    ans = 0
    for i in li:
        ans += i//K
    print(ans)