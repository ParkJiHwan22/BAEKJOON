# 문제

# Python을 사용하고 있다면, input 대신 sys.stdin.readline을 사용할 수 있다. 
# 단, 이때는 맨 끝의 개행문자까지 같이 입력받기 때문에 문자열을 저장하고 싶을 경우
# .rstrip()을 추가로 해 주는 것이 좋다.

# 또한 입력과 출력 스트림은 별개이므로, 테스트케이스를 전부 입력받아서 저장한 뒤 전부 출력할 필요는 없다. 
# 테스트케이스를 하나 받은 뒤 하나 출력해도 된다.

# 입력
# 첫 줄에 테스트케이스의 개수 T가 주어진다. T는 최대 1,000,000이다. 
# 다음 T줄에는 각각 두 정수 A와 B가 주어진다. A와 B는 1 이상, 1,000 이하이다.

# 출력
# 각 테스트케이스마다 A+B를 한 줄에 하나씩 순서대로 출력한다.

# a = int(input())
# lst = []
# for i in range(a):
#     b, c = map(int, input().split())
#     lst += {b*c}

# for i in lst:
#     print(i)

# import sys

# T = int(sys.stdin.readline())
# lst = []

# for i in range(T):
#     A, B = map(int, sys.stdin.readline().split())
#     lst += {A + B}

# for i in lst:
#     print(i)

# sys를 사용해본 적이 없어서 for문으로 먼저 코드를 짜고, 거기에
# sys.stdin.readline()를 대입했음
# 예제 입력 쭉 다하고 출력 해야되는 거 아닌가?
# 아니더라 입력하고 출력값이 섞여있어도 됨

import sys
 
inp = int(input())
for i in range(inp):
        a,b = map(int, sys.stdin.readline().split())
        print(a+b)

# 예제 입력 1 
# 5
# 1 1
# 12 34
# 5 500
# 40 60
# 1000 1000

# 예제 출력 1 
# 2
# 46
# 505
# 100
# 2000