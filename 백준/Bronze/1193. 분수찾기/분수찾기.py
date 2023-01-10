X = int(input())
n = 0
sum = 0

while X > sum:
    n += 1
    sum += n

if n % 2 == 1:
    print(f'{sum - X + 1}/{n - sum + X}')
else:
    print(f'{n - sum + X}/{sum - X + 1}')   