
word_list  = [list(input()) for _ in range(5)]

c_list = []
for i in range(5): # 열의 개수 구하기
    c_list.append(len(word_list[i]))
c = max(c_list)

for i in range(c): # 열의 개수
    for j in range(5): # 행의 개수
        try:
            if word_list[j][i] != ' ':
                print(word_list[j][i], end = '')
        except:
            continue