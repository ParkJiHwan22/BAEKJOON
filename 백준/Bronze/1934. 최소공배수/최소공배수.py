import math

T = int(input())

for i in range(T):
    num_1, num_2 = map(int, input().split())
    print(math.lcm(num_1, num_2))
