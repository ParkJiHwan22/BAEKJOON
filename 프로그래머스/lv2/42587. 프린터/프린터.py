from collections import deque

def solution(priorities, location):
    priorities = deque(priorities)
    now, cnt = 0, 0
    while True:
        if now == len(priorities):
            now = 0
        
        if max(priorities) == priorities[0]:
            priorities.popleft()
            cnt += 1
            if now < location:
                location -= 1
            elif now == location:
                break
        else:
            priorities.append(priorities.popleft())
            now += 1
             
    return cnt