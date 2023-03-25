import math

seat = list(map(int, input().split()))
print(math.ceil(seat[0] / (seat[2] + 1)) * math.ceil(seat[1] / (seat[3] + 1)))