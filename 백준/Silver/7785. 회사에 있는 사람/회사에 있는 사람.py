
import sys

n = int(sys.stdin.readline())
name_list = [sys.stdin.readline().split() for i in range(n)]
name_dict = {}
work_list = []

for i in name_list:
    name_dict[i[0]] = i[1]


for keys in name_dict:
    if name_dict[keys] == 'enter':
       work_list.append(keys)

print(*sorted(work_list, reverse=True), sep = '\n')