n = int(input())
num = [int(input()) for _ in range(n)]
res = 0
num_new = []

cnt = 0
for i in range(n): # 1 먼저 계산
    if num[i] == 1:
        res += num[i]
    else:
        num_new.append(num[i])

num_new = sorted(num_new)

minus, plus = 0, 0 # 음수 + 0, 양수가 각각 몇 개인지 구하기

for i in range(len(num_new)):
    if num_new[i] > 0:
        break
    else:
        minus += 1
    
plus = len(num_new) - minus

if minus % 2 == 0: # 음수 혹은 0 일경우 구하기
    for k in range(0, minus, 2):
        res += num_new[k] * num_new[k+1]
else:
    for k in range(0, minus - 1, 2):
        res += num_new[k] * num_new[k+1]
    res += num_new[minus - 1]

if plus % 2 == 0: # 양수 일경우 구하기
    for j in range(minus, minus + plus, 2):
        res += num_new[j] * num_new[j+1]
else:
    res += num_new[minus]
    for j in range(minus + 1, minus + plus, 2):
        res += num_new[j] * num_new[j+1]

print(res)
    