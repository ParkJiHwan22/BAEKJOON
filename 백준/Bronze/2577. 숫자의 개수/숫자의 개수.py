num_list = [0]*10

A = int(input())
B = int(input())
C = int(input())

num = A*B*C

for i in str(num):
    num_list[int(i)] += 1

print(*num_list, sep='\n')