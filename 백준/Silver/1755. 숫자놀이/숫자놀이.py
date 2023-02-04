
m, n = map(int, input().split())
change_dict = {
    '0': 'zero',
    '1': 'one',
    '2': 'two',
    '3': 'three',
    '4': 'four',
    '5': 'five',
    '6': 'six',
    '7': 'seven',
    '8': 'eight',
    '9': 'nine'
}

strs = [[] for i in range(n+1)]

num_dict = {}
for i in range(m, n+1):
    for j in str(i):
        strs[i].append(change_dict[j])

    strs[i] = ' '.join(strs[i])
    num_dict[strs[i]] = i

result = sorted(num_dict.items())

for j in range(len(result)):
    if (j+1) % 10 == 0:
        print(result[j][1])
    else:
        print(result[j][1], end = ' ')