# 1874 스택 수열
# 문제
# 스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다. 스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 
# 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.

# 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 
# 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 
# 이를 계산하는 프로그램을 작성하라.

# 입력
# 첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다. 둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다. 물론 같은 정수가 두 번 나오는 일은 없다.

# 출력
# 입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다. push연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다.

import sys

n = int(sys.stdin.readline())
input_num = [int(sys.stdin.readline()) for i in range(n)]
num_list = list(range(1, n+1)) # 1 ~ n 까지의 숫자
stack= [] # 다시 숫자를 담을 통
stack_pm = [] # +,- 부호를 담을 통
before_k = 0 
error = 0

for k in input_num:
    while k > before_k:
        stack.append(num_list.pop(0))
        stack_pm.append('+')
        before_k = stack[-1]
    
    if k == before_k:
        stack.pop()
        stack_pm.append('-')

    else:
        if k == stack[-1]:
            stack.pop()
            stack_pm.append('-')
        else:
            error += 1

if error > 0:
    print('NO')
else:
    print(*stack_pm, sep = '\n')

#----------------------------------------
n = int(input())
stack = []
answer = []
flag = 0
cur = 1

for i in range(n):
    num = int(input())
    while cur <= num:       # 입력한 수를 만날 때 까지 오름차순으로 push
        stack.append(cur)
        answer.append("+")
        cur += 1
    # 입력한 수를 만나면 while문 탈출. 즉 cur = num일 때 까지 while문을 돌아 스택을 쌓는다.

    if stack[-1] == num:    # stack의 TOP이 입력한 숫자와 같다면
        stack.pop()         # 스택의 TOP을 꺼내 수열을 만들어 준다.
        answer.append("-")
    else:                   # stack의 TOP이 입력한 수가 아니면 주어진 스택을 만들 수 없다.
        print("NO")         # 왜냐하면 12345 처럼 오름차순으로 스택이 입력되는데
        flag = 1            # TOP이 num보다 크면 num은 TOP보다 더 아래에 쌓여있기 때문이다.
        break               

if flag == 0:
    for i in answer:
        print(i)

# https://hongcoding.tistory.com/39
# 나와 다르게 이 분은 for문 안에서 모든 걸 해결하려했다. 덕분에 변수 개수가 적고 보기가 쉽다.
# 나는 리스트를 두개 만들어서 옮겨담으면서 중복을 피했는데 이 분은 cur += 1을 이용해서 구현했다.


# 예제 입력 1 
# 8
# 4
# 3
# 6
# 8
# 7
# 5
# 2
# 1
# 예제 출력 1 
# +
# +
# +
# +
# -
# -
# +
# +
# -
# +
# +
# -
# -
# -
# -
# -

# 예제 입력 2 
# 5
# 1
# 2
# 5
# 3
# 4
# 예제 출력 2 
# NO