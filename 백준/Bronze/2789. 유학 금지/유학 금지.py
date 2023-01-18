cambridge = ['C', 'A', 'M', 'B', 'R', 'I', 'D', 'G', 'E']

word = input()
lst = []

for i in word:
    if i not in cambridge:
        lst.append(i)

print(*lst, sep='')