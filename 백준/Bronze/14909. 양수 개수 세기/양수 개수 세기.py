num_list = list(map(int, input().split()))
cnt = 0

for i in num_list:
    if i > 0:
        cnt += 1
        
print(cnt)