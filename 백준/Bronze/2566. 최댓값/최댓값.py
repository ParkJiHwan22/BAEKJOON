lst = []
num = 0

for i in range(9):
    row = list(map(int, input().split()))
    lst.append(row)

for j in range(9):
    for k in range(9):
        if lst[j][k] >= num:
            a = j + 1
            b = k + 1
            num = lst[j][k]

print(num)
print(a, b)