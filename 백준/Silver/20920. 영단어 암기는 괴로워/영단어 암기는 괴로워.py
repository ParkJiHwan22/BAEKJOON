import sys
input = sys.stdin.readline

n, m = map(int, input().split())
words_dic = {}
for i in range(n):
    word = input().rstrip()
    
    if len(word) >= m:
        if word in words_dic:
            words_dic[word] += 1
            
        else:
            words_dic[word] = 1

sorted_words_dic = dict(sorted(words_dic.items(), key=lambda item: (-item[1], -len(item[0]), item[0] )))
for dir in sorted_words_dic.keys():
    print(dir)