# 최대공약수와 최소공배수
# 문제
# 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.

# 입력
# 첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.

# 출력
# 첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.

# num_1, num_2 = map(int, input().split())
# list_num_1 = []
# multiple_num = num_1 * num_2

# for i in range(2, num_1+1):
#     while True:
#         if num_1 % i == 0:
#             list_num_1.append(i)
#             num_1 = num_1/i
#         else:
#             break

# gcd = 1
# for i in list_num_1:
#     if num_2 % i == 0:
#         gcd *= i
#         num_2 = num_2/i

# print(gcd)
# print(int(multiple_num/gcd))


# math 에 최대공약수, 최소공배수 구하는 함수가 있음

import math
num_1, num_2 = map(int, input().split())
print(math.gcd(num_1, num_2)) # 최대공약수
print(math.lcm(num_1, num_2)) # 최소공배수


# # 유클리드 호제법

# a, b = map(int, input().split())

# def gcd(a, b):
#     while b > 0:
#         a, b = b, a % b
#     return a

# def lcm(a, b):
#     return a * b // gcd(a, b)

# print(gcd(a, b))
# print(lcm(a, b))


# 예제 입력 1 
# 24 18

# 예제 출력 1 
# 6
# 72