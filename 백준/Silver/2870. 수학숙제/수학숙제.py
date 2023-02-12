import sys

n = int(sys.stdin.readline())

word_list = [sys.stdin.readline().rstrip() for _ in range(n)]
num_list = []

for word in word_list:
    tmp = ''
    for i in word:
        if 97 <= ord(i) <= 122:
            if len(tmp) > 0:
                num_list.append(int(tmp))
                tmp = ''
        else:
            tmp += i
        
    if len(tmp) > 0:
        num_list.append(int(tmp))

print(*sorted((num_list)), sep = '\n')