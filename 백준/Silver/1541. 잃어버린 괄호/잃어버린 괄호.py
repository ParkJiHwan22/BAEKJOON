word = input().split('-')
num = []

for n in word:
    cnt = 0
    num_list = n.split('+')
    for j in num_list:
        cnt += int(j)
    num.append(cnt)

ans = num[0]
for i in range(1, len(num)):
    ans -= num[i]
print(ans)