N = int(input())
num_list = list(map(int, input().split()))
using_pc = []
reject = 0

for i in num_list:
    if i not in using_pc:
        using_pc.append(i)
    else:
        reject += 1

print(reject)