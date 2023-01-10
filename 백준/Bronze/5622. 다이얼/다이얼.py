text = input()
sum = 0
lst = ['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ']

for i in text:
    for j in lst:
        if i in j:
            sum += 3 + lst.index(j)

print(sum)