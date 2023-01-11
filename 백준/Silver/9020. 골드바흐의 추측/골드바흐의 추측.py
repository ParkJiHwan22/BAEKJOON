lst = []

for i in range(2, 10001):
    for j in range(2,int(i**0.5)+1):
        if i % j == 0: # 약수가 존재하므로 소수가 아님
            break   #더이상 검사할 필요가 없으므로 멈춤
    else:
        lst.append(i)

T = int(input())


for i in range(T):
    n = int(input())
    if n/2 in lst:
        print(int(n/2), int(n/2))
        continue
    num = n
    for j in lst:
        if n/2 <= j:
            print(n-num, num)
            break

        elif n - j in lst:
            if num >= n - j:
                num = n - j    