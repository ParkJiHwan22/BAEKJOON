n = int(input())
cnt = 0

for x in range(10000000):
    if '666' in str(x):
        cnt += 1
        num = x
    
    if cnt == n:
        break

print(num)