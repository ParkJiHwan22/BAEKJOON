n = int(input())
size_list = [list(map(int, input().split())) for i in range(n)]
rank = [1]*n

for i in range(n):
    for j in range(n):
        if size_list[i][0] < size_list[j][0] and size_list[i][1] < size_list[j][1]:
            rank[i] += 1

print(*rank)
