n = int(input())
num = [int(input()) for _ in range(n)]
res = 0
num_new = []

for i in range(n): # 1 먼저 계산
    if num[i] == 1:
        res += num[i]
    else:
        num_new.append(num[i]) # 1이 아닌 수는 새로운 리스트에 담음

num_new = sorted(num_new)

minus, plus = 0, 0 # 음수 + 0, 양수가 각각 몇 개인지 구하기
for i in range(len(num_new)):
    if num_new[i] > 0:
        break
    else:
        minus += 1 # 자연수가 아닌 수의 개수
    
plus = len(num_new) - minus # 자연수 개수

if minus % 2 == 0: # 자연수 아닐 경우 구하기
    for k in range(0, minus, 2): # minus의 개수가 짝수 일 경우
        res += num_new[k] * num_new[k+1]
else:
    for k in range(0, minus - 1, 2): # minus의 개수가 홀수 일 경우
        res += num_new[k] * num_new[k+1]
    res += num_new[minus - 1]

if plus % 2 == 0: # 자연수 경우 구하기
    for j in range(minus, minus + plus, 2): # plus의 개수가 짝수 일 경우
        res += num_new[j] * num_new[j+1]
else:
    res += num_new[minus]
    for j in range(minus + 1, minus + plus, 2): # plus의 개수가 홀수 일 경우
        res += num_new[j] * num_new[j+1]

print(res)   