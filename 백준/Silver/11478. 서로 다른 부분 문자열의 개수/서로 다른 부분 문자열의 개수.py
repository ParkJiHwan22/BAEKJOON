S = input()
str_dict = {}

for i in range(1,len(S)+1):
    for j in range(0,len(S),i):
        for k in range(0,len(S)+1-i-j):
            str_dict[S[j+k:j+i+k]] = 0

print(len(str_dict))