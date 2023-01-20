# 2751 수 정렬하기 2
# 문제
# N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

# 입력
# 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 
# 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

# 출력
# 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

# sys.stdin.readline() 써야함
# input() 내장 함수는 sys.stdin.readline()과 비교해서 prompt message를 출력하고,개행 문자를 삭제한 값을 리턴하기 때문에 느림

import sys

T = int(input())
num_list = [int(sys.stdin.readline()) for i in range(T)]

num_list.sort()
print(*num_list, sep='\n')


# 예제 입력 1 
# 5
# 5
# 4
# 3
# 2
# 1
# 예제 출력 1 
# 1
# 2
# 3
# 4
# 5