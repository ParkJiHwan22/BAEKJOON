import sys
from collections import deque
input = sys.stdin.readline

front_word = deque(list(input().rstrip()))
back_word = deque()

n = int(input())

for _ in range(n):
    command = input().rstrip()

    if command == 'L':
        if front_word:
            back_word.appendleft(front_word.pop())
    elif command == 'D':
        if back_word:
            front_word.append(back_word.popleft())
    elif command == 'B':
        if front_word:
            front_word.pop()
    elif 'P' in command:
        front_word.append(command[2])    
    
print(''.join(front_word)+''.join(back_word))
