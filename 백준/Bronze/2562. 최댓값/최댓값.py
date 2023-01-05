lst = []

for i in range(1,10):
    num = int(input())
    lst.append(num)

for i in lst:
    if i >= max(lst):
        idx = lst.index(i) + 1


print(max(lst), idx, sep="\n")