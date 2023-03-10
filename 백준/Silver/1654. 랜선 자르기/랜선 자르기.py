K, N = map(int, input().split())
lan_list = [int(input()) for i in range(K)]

start = 1
end = max(lan_list)
result = 0

while start <= end:
    mid = (start + end) // 2
    cnt = 0

    for x in lan_list:
        cnt += x // mid

    if cnt < N:
        end = mid - 1
    else:
        result = mid
        start = mid + 1
        
print(result)