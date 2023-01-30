import sys

T = int(sys.stdin.readline())
word_list = [sys.stdin.readline().strip() for _ in range(T)]

res = 0

for x in word_list:
    alphabet = [0]*26
    alphabet[(ord((x[0]))-97)] += 1
    for i in range(1, len(x)):
        if x[i] == x[i-1]:
            continue
        else:
            alphabet[(ord((x[i]))-97)] += 1

    cnt = 1
    for j in range(len(alphabet)):
        if alphabet[j] > 1:
            cnt = 0
            break
        else:
            continue
    
    res += cnt

print(res)