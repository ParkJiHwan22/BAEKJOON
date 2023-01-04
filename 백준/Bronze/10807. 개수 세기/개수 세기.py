num = int(input())
num_d = input().split()
num_f = int(input())
cnt = 0

for i in num_d:
    if int(i) == num_f:
        cnt += 1

print(cnt)