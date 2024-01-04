n = int(input())
num_list = [int(input()) for _ in range(9)]

total = 0
for i in num_list:
    total += i
    
print(n - total)