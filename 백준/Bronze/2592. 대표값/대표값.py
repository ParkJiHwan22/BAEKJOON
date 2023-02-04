from collections import Counter

num_list = [int(input()) for i in range(10)]
mode =  Counter(num_list).most_common(1)
print(sum(num_list)//10)
print(mode[0][0])