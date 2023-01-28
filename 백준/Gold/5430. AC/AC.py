import sys
from collections import deque

T = int(sys.stdin.readline())

for i in range(T):
    p = sys.stdin.readline()
    n = int(sys.stdin.readline())
    num_str = sys.stdin.readline()
    
    num_queue = deque()
    num_str = num_str[1:-2]

    num = ''
    
    for i in num_str:
        if i == ',':
            num_queue.append(int(num))
            num = ''
        else:
            num += i

    if num != '':
        num_queue.append(int(num))

    R_count = 0

    for j in p:
        if j == 'R':
            R_count += 1
        elif j == 'D': 
            try:       
                if R_count % 2 == 1:
                    num_queue.pop()
                else:
                    num_queue.popleft()
            except:
                R_count = -1
                break
    res = '['
    if R_count >= 0:
        if R_count % 2 == 1:
            for x in reversed(num_queue):
                res += str(x)
                res += ','
            
            if res[-1] == ',':
                print(res[0:-1] + ']')
            elif res == '[':
                print('[]')
        else:
            for x in num_queue:       
                res += str(x)
                res += ','
            
            if res[-1] == ',':
                print(res[0:-1] + ']')
            elif res == '[':
                print('[]')

    else:
        print('error')