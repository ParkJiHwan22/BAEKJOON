# 1051 숫자 정사각형
# 문제
# N×M크기의 직사각형이 있다. 각 칸에는 한 자리 숫자가 적혀 있다. 이 직사각형에서 꼭짓점에 쓰여 있는 수가 모두 같은 가장 큰 정사각형을 찾는 프로그램을 작성하시오. 이때, 정사각형은 행 또는 열에 평행해야 한다.

# 입력
# 첫째 줄에 N과 M이 주어진다. N과 M은 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 수가 주어진다.

# 출력
# 첫째 줄에 정답 정사각형의 크기를 출력한다.

# import sys

# n, m = map(int, sys.stdin.readline().split())
# rectangle = [sys.stdin.readline().strip() for _ in range(n)]

# rec_list = [[] for _ in range(n)]
# for r in range(len(rectangle)):
#     for num in rectangle[r]:
#         rec_list[r].append(num)

# area = 1
# for k in range(1, min(n, m)): 
#     for i in range(n - k):
#         for j in range(m - k):
#             if rectangle[i][j] == rectangle[i+k][j] == rectangle[i][j+k] == rectangle[i+k][j+k]:
#                 if area <= (k+1)**2:
#                     area = (k+1)**2

# print(area)

# 예제 입력 1 
# 3 5
# 42101
# 22100
# 22101
# 예제 출력 1 
# 9
# 예제 입력 2 
# 2 2
# 12
# 34
# 예제 출력 2 
# 1
# 예제 입력 3 
# 2 4
# 1255
# 3455
# 예제 출력 3 
# 4
# 예제 입력 4 
# 1 10
# 1234567890
# 예제 출력 4 
# 1
# 예제 입력 5 
# 11 10
# 9785409507
# 2055103694
# 0861396761
# 3073207669
# 1233049493
# 2300248968
# 9769239548
# 7984130001
# 1670020095
# 8894239889
# 4053971072
# 예제 출력 5 
# 49

