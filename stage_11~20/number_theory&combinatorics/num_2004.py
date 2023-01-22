# 2004 조합 0의 개수
# 문제
# (n,m)의 끝자리 0의 개수를 출력하는 프로그램을 작성하시오.

# 입력
# 첫째 줄에 정수 
# n, m (0 <= m, n <= 2,000,000,000, n != 0)이 들어온다.

# 출력
# 첫째 줄에 (n,m)의 끝자리 0의 개수를 출력한다.

import sys

n, m = map(int, sys.stdin.readline().split())
two_factorial = 0
five_factorial = 0

# nCr = n!/((n-r)!*r!)

for i in range(1,31): # 2**30 = 1,073,741,824
    if n >= 2**i:
        two_factorial += (n // (2**i)) - (((n-m) // (2**i)) + (m // (2**i)))
    else:
        pass
for i in range(1,14): # 5**13 = 1,220,703,125
    if n >= 5**i:
        five_factorial += (n // (5**i)) - (((n-m) // (5**i)) + (m // (5**i)))
    else:
        pass

print(min(two_factorial, five_factorial))



# n, m = map(int, input().split())


# def two_count(n):
#     two = 0
#     while n != 0:
#         n = n // 2
#         two += n
#     return two

# def five_count(n):
#     five = 0
#     while n != 0:
#         n = n // 5
#         five += n
#     return five

# print(min(two_count(n) - two_count(n - m) - two_count(m), five_count(n) - five_count(n - m) - five_count(m)))

# 예제 입력 1 
# 25 12
# 예제 출력 1 
# 2