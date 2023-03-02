n, m = map(int, input().split())
num_list = list(range(n+1))

for x in range(m):
    i, j, k = map(int, input().split())

    tmp = num_list[i:j+1]
    for y in range(k-i):
       tmp.append(tmp.pop(0))
    
    num_list = num_list[0:i] + tmp + num_list[j+1:]

print(*num_list[1:])