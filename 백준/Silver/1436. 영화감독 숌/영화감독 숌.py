n = int(input())
cnt = 0

for i in range(10000000): # 10000번째 2,666,799
    if '666' in str(i):
        cnt += 1
        
    if n == cnt:
        print(i)
        break