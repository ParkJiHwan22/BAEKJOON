word = input()
alphabet_dic = {}

for i in range(97, 123):
    alphabet_dic[chr(i)] = 0

for j in word:
    alphabet_dic[j] += 1
    
print(*alphabet_dic.values())