n = input()
num_list = [int(i) for i in n]
num_list.sort()
num_list.reverse()
print(*num_list, sep ='')
