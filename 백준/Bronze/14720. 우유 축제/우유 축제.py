n = int(input())
cnt = 0

num_list = list(map(int, input().split()))

for i in num_list:
    if cnt % 3 == i:
        cnt += 1

print(cnt) 