X = int(input())
Y = int(input())
sum = 0

for i in range(Y):
    a, b = map(int, input().split())
    sum += a * b

if sum == X: 
    print('Yes')
else: 
    print('No')