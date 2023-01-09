N = int(input())
word_list = []
dict_word = {}
cnt = 0
sum = 0

for i in range(N):
    word = input()
    word_list.append(word)

for i in word_list:
    k = ''
    for j in i:
        if j in dict_word:
            if k == j:
                dict_word[j] += 1
                k = j
            else:
                cnt += 1
        else:
            dict_word[j] = 1
            k = j

    if cnt == 0:
        sum += 1
        cnt = 0
        dict_word.clear()
    else:
        cnt = 0
        dict_word.clear()

print(sum)