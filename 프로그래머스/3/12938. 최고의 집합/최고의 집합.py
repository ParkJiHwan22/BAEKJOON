import sys
input = sys.stdin.readline

def solution(n, s):
    share = s // n
    remain = s % n
    answer = []
    
    if n > s:
        return [-1]
    
    for i in range(n):
        if i < remain:
            answer.append(share + 1)
        else:
            answer.append(share)
    
    answer = sorted(answer)
    return answer