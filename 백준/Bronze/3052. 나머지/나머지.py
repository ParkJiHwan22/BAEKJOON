lst = []
dict_variable = {}

for i in range(10):
    A = int(input())
    lst.append(A%42)

for i in lst:
    cnt = 0
    for j in lst:
        if i == j:
            cnt += 1
    dict_variable[i] = cnt

cnt_2 = 0
for i in dict_variable.keys():
    cnt_2 += 1

print(cnt_2)