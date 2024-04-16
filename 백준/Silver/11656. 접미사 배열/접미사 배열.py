s = input()
arr = []
for i in range(1, len(s)+1):
    arr.append(s[len(s)-i:len(s)])

arr = sorted(arr)

for word in arr:
    print(word, end="\n")