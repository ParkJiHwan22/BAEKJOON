import math

n = int(input())
lst = [int(input()) for _ in range(4)]
print(n - (max(math.ceil(lst[0] / lst[2]), math.ceil(lst[1] / lst[3]))))