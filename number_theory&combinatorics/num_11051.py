# 11051 이항 계수 2
# 문제
# 자연수 N과 정수 K가 주어졌을 때 이항 계수 ({N}{K})를 10,007로 나눈 나머지를 구하는 프로그램을 작성하시오.

# 입력
# 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ K ≤ N)

# 출력
# ({N}{K})를 10,007로 나눈 나머지를 출력한다.

# import sys
# input = sys.stdin.readline

# N, K = map(int, input().split())

# def factorial(n):
#     if n == 0 or n == 1:
#         return 1
#     else:
#         return n*factorial(n-1)

# binomial = factorial(N)//(factorial(N-K)*factorial(K))
# print(binomial % 10007)
# 이건 재귀함수가 돌 때 시간복잡도가 높아져서 그런걸까 O(N²)인 것 같다

from math import factorial
N, K = map(int, input().split())
result = factorial(N) // (factorial(K) * factorial(N - K))
print(result % 10007)
# math 함수에서 factorial만 꺼낸다

# 예제 입력 1 
# 5 2
# 예제 출력 1 
# 10