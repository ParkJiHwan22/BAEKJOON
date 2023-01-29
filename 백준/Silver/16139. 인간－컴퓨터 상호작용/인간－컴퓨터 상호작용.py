import sys

words = sys.stdin.readline()
T = int(sys.stdin.readline())

a, l, r = sys.stdin.readline().split()

location = [0]*len(words)

for i in range(len(words)):
    for x in range(97,123):
        if chr(x) == words[i]:
            location[i] = chr(x)


print(location[int(l):int(r)+1].count(a))

for j in range(T-1):
    a, l, r = sys.stdin.readline().split()
    print(location[int(l):int(r)+1].count(a))