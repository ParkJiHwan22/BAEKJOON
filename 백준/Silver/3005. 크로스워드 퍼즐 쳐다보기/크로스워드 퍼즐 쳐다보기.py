r, c = map(int, input().split())
cross_word = [input() for _ in range(r)]

dictionary = []
for i in range(r):
    words = ''
    for j in range(c):
        if cross_word[i][j] != '#':
            words += cross_word[i][j]
        else:
            if len(words) >= 2:
                dictionary.append(words)
                words = ''
            else:
                words = ''
    if len(words) >= 2:
        dictionary.append(words)

for x in range(c):
    words = ''
    for y in range(r):
        if cross_word[y][x] != '#':
            words += cross_word[y][x]
        else:
            if len(words) >= 2:
                dictionary.append(words)
                words = ''
            else:
                words = ''
    if len(words) >= 2:
        dictionary.append(words)

print(list(sorted(dictionary))[0])