n = int(input())
sireal_num = [input() for _ in range(n)]

sireal_list = [[] for _ in range(n)]

t = 0
for i in sireal_num:
    sireal_list[t].append(len(i))
    t += 1

tt = 0
for x in sireal_num:
    total = 0
    for y in x:
        if str(y) in ['1', '2', '3', '4', '5', '6', '7', '8', '9']:
            total += int(y)

    sireal_list[tt].append(total)
    tt += 1

ttt = 0
for k in sireal_num:
    for l in k:
        sireal_list[ttt].append(ord(l))
    ttt += 1

tttt = 0
for i in sireal_num:
    sireal_list[tttt].append(i)
    tttt += 1

sireal_list = (sorted(sireal_list))

for res in range(n):
    print(sireal_list[res][-1])
    