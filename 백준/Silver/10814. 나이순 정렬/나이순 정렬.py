import sys

n = int(sys.stdin.readline())
data_list = []

for i in range(n):
    [age, name] = list(sys.stdin.readline().split())
    data_list.append([int(age), i , name])

data_list.sort(key= lambda x: (x, age))
for i in range(n):
    print(data_list[i][0], data_list[i][2])