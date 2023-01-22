# # 11050 이항계수 1
# # 문제
# # 자연수 N과 정수 K가 주어졌을 때 이항 계수 ({N}{K})를 구하는 프로그램을 작성하시오.

# # 입력
# # 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 0 ≤ K ≤ N)

# # 출력
 
# # ({N}{K})를 출력한다.
# result = 1
# N, K = map(int, input().split())
# for i in range(1, K+1):
#     result *= (N - i + 1 )/i

# print(int(result))


# # 재귀함수를 써서 푸는 법을 공부해보자

# import sys
# input = sys.stdin.readline

# N, K = map(int, input().split())

# def factorial(n):
#   if n == 0 or n == 1:
#     return 1
#   else:
#     return n * factorial(n-1)

# # 조합 공식 nCk = n!/(n-k)!k!
# print(factorial(N) // (factorial(N-K) * factorial(K)))


# # 예제 입력 1 
# # 5 2
# # 예제 출력 1 
# # 10