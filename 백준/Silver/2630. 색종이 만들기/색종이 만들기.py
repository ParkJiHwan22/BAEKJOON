import sys

n = int(sys.stdin.readline())
first_n = n
confetti = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
white, blue = 0, 0

while n >= 1:
    for k in range(0, first_n, n):
        for m in range(0, first_n, n):
            cnt = 0
            for i in range(k, n + k):
                for j in range(m, n + m):
                    cnt += confetti[i][j]
        
            if cnt == n**2:
                blue += 1
                for i in range(k, n + k):
                    for j in range(m, n + m):
                        confetti[i][j] = -1
                        
            elif cnt == 0:
                white += 1
                for i in range(k, n + k):
                    for j in range(m, n + m):
                        confetti[i][j] = -1
    
    n = n//2
    
print(white)
print(blue)
