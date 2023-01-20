n, m = map(int, input().split())
num_list = list(map(int, input().split()))
cnt = 0
max_num = 0

for i in range(n-2):
    for j in range(i+1,n-1):
        for k in range(j+1,n):
            if num_list[i] + num_list[j] + num_list[k] == m:
                cnt += 1
            elif m > num_list[i] + num_list[j] + num_list[k]:
                if num_list[i] + num_list[j] + num_list[k] > max_num:
                    max_num = num_list[i] + num_list[j] + num_list[k]

if cnt > 0:
    print(m)
else:
    print(max_num)