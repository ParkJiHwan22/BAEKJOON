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
