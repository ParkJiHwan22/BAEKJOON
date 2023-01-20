import sys
from collections import Counter

n = int(input())
num_list = [int(sys.stdin.readline()) for i in range(n)]
num_list = sorted(num_list)

# 산술평균을 출력
print(round(sum(num_list)/n))


# 중앙값을 출력
print(num_list[(n-1)//2])


# # 최빈값을 출력
num_dict = Counter(num_list) # Counter({-2: 1, 1: 1, 2: 1, 3: 1, 8: 1})
if n == 1:
    most_dict = Counter(num_list).most_common(1) # (-2, 2)
    print(most_dict[0][0])

else:
    most_2_dict = Counter(num_list).most_common(2)
    if most_2_dict[0][1] == most_2_dict[1][1]:
        print(most_2_dict[1][0])
    else:
        print(most_2_dict[0][0])


# 범위를 출력
print(max(num_list)-min(num_list))