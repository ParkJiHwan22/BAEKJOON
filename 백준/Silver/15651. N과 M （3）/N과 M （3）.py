from itertools import product

n, m = map(int, input().split())
num = [i for i in range(1, n+1)]

answer = list(product(num, repeat = m))

for x in answer:
    num_list = []
    for y in x:
        num_list.append(y)
    print(*num_list, sep = ' ')