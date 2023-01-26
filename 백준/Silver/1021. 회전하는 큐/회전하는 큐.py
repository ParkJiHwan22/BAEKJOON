from collections import deque

N, M = map(int, input().split())
num_list = deque(map(int, input().split()))
queue = deque(range(1, N+1))
cnt = 0

while len(queue) > N - M:
    for i in range(len(queue)):
        if queue[i] == num_list[0]:
            if i <= (len(queue) // 2):
                for j in range(i):
                    queue.append(queue.popleft())
                    cnt += 1
                queue.popleft()
                num_list.popleft()
                break
            else:
                for j in range(len(queue) - i):
                    queue.appendleft(queue.pop())
                    cnt += 1
                queue.popleft()
                num_list.popleft()
                break

print(cnt)