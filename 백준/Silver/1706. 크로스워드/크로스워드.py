R, C = map(int, input().split())
word_list = [input().split() for _ in range(R)]

word_list_reverse = []

for f in range(C):
    word_reverse = ''
    for t in range(R):
        word_reverse += word_list[t][0][f]
    word_list_reverse.append(word_reverse)

dic = []
res = []

for i in range(R): # 가로에서 단어 추출하기
    for word_str in word_list[i]:
        word = ''
        for x in word_str:
            if x != '#':
                word += x
            else:
                dic.append(word)
                word = ''

        dic.append(word)


for word_str in word_list_reverse: # 세로에서 단어 추출하기
    word = ''
    for x in word_str:
        if x != '#':
            word += x
        else:
            dic.append(word)
            word = ''

    dic.append(word)


for j in dic:
    if len(j) >= 2:
        res.append(j)

res = sorted(res)
print(res[0])