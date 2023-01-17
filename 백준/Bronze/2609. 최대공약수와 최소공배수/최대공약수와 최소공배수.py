num_1, num_2 = map(int, input().split())
list_num_1 = []
multiple_num = num_1 * num_2

for i in range(2, num_1+1):
    while True:
        if num_1 % i == 0:
            list_num_1.append(i)
            num_1 = num_1/i
        else:
            break

gcd = 1
for i in list_num_1:
    if num_2 % i == 0:
        gcd *= i
        num_2 = num_2/i

print(gcd)
print(int(multiple_num/gcd))