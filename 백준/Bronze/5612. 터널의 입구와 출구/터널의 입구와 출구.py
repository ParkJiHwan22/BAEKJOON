n = int(input())
m = int(input())
max_num = m
err = 0

for i in range(n):
    a, b = map(int, input().split())
    m += (a - b)
    if max_num < m:
        max_num = m
        
    if m < 0:
        err += 1
    
if err == 0:
    print(max_num)
else:
    print(0)