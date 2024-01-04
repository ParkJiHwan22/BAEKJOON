n = int(input())
cnt = 1
fibo = [(0, 0), (1, 1)]

while cnt < n:    
    cnt += 1
    fibo.append((cnt, fibo[cnt - 1][1] + fibo[cnt - 2][1]))
    
print(fibo[-1][1])