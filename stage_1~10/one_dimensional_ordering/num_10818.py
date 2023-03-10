# 문제
# N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.

# 입력
# 첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 
# 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다. 
# 모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 
# 같은 정수이다.

# 출력
# 첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.

# 예제 입력 1 
# 5
# 20 10 35 30 7

# 예제 출력 1 
# 7 35

# N = int(input())
# lst_A = []

# for i in range(N):
#     A = int(input())
#     lst_A.append(A)

# print(min(lst_A), max(lst_A))

# 문제가 이해가 안되서 글을 이곳저곳에서 찾아보는데 N이 쓰이지 않았는데도
# 답이 맞았다고 처리되는지 모르겠다. 차라리 N의 조건이 없었어야 할 것 같다.

n = int(input())
lst = list(map(int, input().split()))

print(min(lst), max(lst))

# [출처] [백준 알고리즘 Baekjoon] 10818번 python (최소, 최대)|작성자 건우