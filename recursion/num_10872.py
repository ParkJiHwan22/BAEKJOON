# 10872 팩토리얼
# 문제
# 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.

# 입력
# 첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다.

# 출력
# 첫째 줄에 N!을 출력한다.

# 예제 입력 1 
# 10
# 예제 출력 1 
# 3628800

# 예제 입력 2 
# 0
# 예제 출력 2 
# 1

# from math import factorial

# n= int(input())

# print(factorial(n))


n = int(input())

def factorial(n):
    if n == 1:
        return 1
    else:
        result = n * factorial(n-1)
        return result

print(factorial(n))