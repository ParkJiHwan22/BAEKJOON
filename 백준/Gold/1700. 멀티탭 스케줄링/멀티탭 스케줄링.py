from collections import deque

n, k = map(int, input().split())
num_list = list(map(int, input().split()))

cnt = 0
multi_tap = []
queue = deque()
for i in range(k):
    if num_list[i] in multi_tap:
        continue
    elif len(multi_tap) < n:
        multi_tap.append(num_list[i])
    
    else:
        cnt += 1
        for j in range(i, k):
            if num_list[j] in multi_tap:
                queue.appendleft(multi_tap.pop(multi_tap.index(num_list[j])))
            
        if len(queue) == n:
            queue.popleft()
            while queue:
                multi_tap.append(queue.popleft())
            multi_tap.append(num_list[i])
        else:
            multi_tap.pop()
            while queue:
                multi_tap.append(queue.popleft())
            multi_tap.append(num_list[i])
                
print(cnt)
            