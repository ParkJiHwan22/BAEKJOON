import sys

words = sys.stdin.readline()
T = int(sys.stdin.readline())

a, l, r = sys.stdin.readline().split()

location = {}

for i in range(len(words)):
    for x in range(97,123):
        if chr(x) == words[i]:
            location[i] = chr(x)
cnt = 0
for k in range(int(l), int(r)+1):
    if location[k] == a:
        cnt += 1
print(cnt)

for j in range(T-1):
    a, l, r = sys.stdin.readline().split()

    cnt = 0
    for k in range(int(l), int(r)+1):
        if location[k] == a:
            cnt += 1
    print(cnt)