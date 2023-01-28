# 5430 AC
# 문제
# 선영이는 주말에 할 일이 없어서 새로운 언어 AC를 만들었다. AC는 정수 배열에 연산을 하기 위해 만든 언어이다. 이 언어에는 
# 두 가지 함수 R(뒤집기)과 D(버리기)가 있다.

# 함수 R은 배열에 있는 수의 순서를 뒤집는 함수이고, D는 첫 번째 수를 버리는 함수이다. 배열이 비어있는데 D를 사용한 경우에는 
# 에러가 발생한다.

# 함수는 조합해서 한 번에 사용할 수 있다. 예를 들어, "AB"는 A를 수행한 다음에 바로 이어서 B를 수행하는 함수이다. 예를 들어, 
# "RDD"는 배열을 뒤집은 다음 처음 두 수를 버리는 함수이다.

# 배열의 초기값과 수행할 함수가 주어졌을 때, 최종 결과를 구하는 프로그램을 작성하시오.

# 입력
# 첫째 줄에 테스트 케이스의 개수 T가 주어진다. T는 최대 100이다.

# 각 테스트 케이스의 첫째 줄에는 수행할 함수 p가 주어진다. p의 길이는 1보다 크거나 같고, 100,000보다 작거나 같다.

# 다음 줄에는 배열에 들어있는 수의 개수 n이 주어진다. (0 ≤ n ≤ 100,000)

# 다음 줄에는 [x1,...,xn]과 같은 형태로 배열에 들어있는 정수가 주어진다. (1 ≤ xi ≤ 100)

# 전체 테스트 케이스에 주어지는 p의 길이의 합과 n의 합은 70만을 넘지 않는다.

# 출력
# 각 테스트 케이스에 대해서, 입력으로 주어진 정수 배열에 함수를 수행한 결과를 출력한다. 만약, 에러가 발생한 경우에는 error를 출력한다.

import sys
from collections import deque

T = int(sys.stdin.readline())

for i in range(T):
    p = sys.stdin.readline()
    n = int(sys.stdin.readline())
    num_str = sys.stdin.readline() # [1,1,2,3,5,8] 이런 식으로 받아서 너무 힘들었다, 리스트처럼 생겼지만 문자열로 받았음
    
    num_queue = deque()
    num_str = num_str[1:-2] # 괄호를 벗겨내는 작업

    num = ''
    
    for i in num_str:
        if i == ',': # 콤마가 나왔을 때, 콤마 이전의 수를 이어놓은 것을 int로 변환
            num_queue.append(int(num))
            num = ''
        else: # 숫자를 전부 이음 42같은 경우 문자열 4 2를 더하면 42가 되고 위의 과정에서 int로 변환
            num += i

    if num != '': # 공백이 아닐 때
        num_queue.append(int(num)) # 마지막에는 ,가 안붙기 때문에 마지막에 있던 숫자를 큐에 넣음 

    R_count = 0 # 판별기

    for j in p: # R과 D의 처리 메커니즘, R의 경우 카운트에 1을 더해서 몇번 뒤집혔는지 계산한 값을 2로 나누면 됨
        if j == 'R':
            R_count += 1
        elif j == 'D': 
            try: # 뺄 수 있으면 빼고, 못 빼는 경우에는 error를 내기위해 R_count를 -1로 고정하고 break
                if R_count % 2 == 1:
                    num_queue.pop()
                else:
                    num_queue.popleft()
            except:
                R_count = -1
                break
    res = '['
    if R_count >= 0: # R_count의 결과에 따라 res이 홀수일 경우 큐를 뒤집는다
        if R_count % 2 == 1: # R_count의 결과가 홀 수 일 때
            for x in reversed(num_queue):
                res += str(x) # [x,y, ... 의 형식을 만들음
                res += ','
            
            if res[-1] == ',': # 숫자가 하나라도 있을 경우 ,로 끝남
                print(res[0:-1] + ']') # 마지막 콤마는 빼고 ]로 닫아서 식을 만든다
            elif res == '[': # 숫자가 없을 경우
                print('[]')
        else:  # R_count의 결과가 홀 수 일 때
            for x in num_queue:      
                res += str(x)
                res += ','
            
            if res[-1] == ',':
                print(res[0:-1] + ']')
            elif res == '[':
                print('[]')

    else: # R_count값이 음수가 나올경우 error출력
        print('error')

#----------------------------------------------------
from collections import deque
 
t = int(input())
 
for i in range(t):
    p = input()
    n = int(input())
    arr = input()[1:-1].split(',')
 
    queue = deque(arr)
 
    flag = 0
 
    if n == 0:
        queue = []
 
    for j in p:
        if j == 'R':
            flag += 1
        elif j == 'D':
            if len(queue) == 0:
                print("error")
                break
            else:
                if flag % 2 == 0:
                    queue.popleft()
                else:
                    queue.pop()
 
    else:
        if flag % 2 == 0:
            print("[" + ",".join(queue) + "]")
        else:
            queue.reverse()
            print("[" + ",".join(queue) + "]")


# 예제 입력 1 
# 4
# RDD
# 4
# [1,2,3,4]
# DD
# 1
# [42]
# RRD
# 6
# [1,1,2,3,5,8]
# D
# 0
# []

# 예제 출력 1 
# [2,1]
# error
# [1,2,3,5,8]
# error

