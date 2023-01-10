t = 0
sum = 0
lst = []

for i in range(10000):
    for j in str(i):
        sum += int(j)
    
    t = i + sum
    sum = 0

    if t <= 10000:
        if t not in lst:
            lst.append(t)
    else:
        t = 0

for i in range(10001):
    if i not in lst:
        print(i)