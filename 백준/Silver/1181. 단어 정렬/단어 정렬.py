import sys

n = int(sys.stdin.readline())

num_word_list = []
word_list = []

for i in range(n):
   x = str(sys.stdin.readline().strip())
   y = len(x)
   num_word_list.append([y, x])

# num_word_list = list(set(num_word_list()))
num_word_list.sort()
for i in range(n):
    if num_word_list[i][1] not in word_list:
        word_list.append(num_word_list[i][1])

print(*word_list, sep='\n')