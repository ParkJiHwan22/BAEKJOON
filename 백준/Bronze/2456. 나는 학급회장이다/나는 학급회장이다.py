import sys
input = sys.stdin.readline

n = int(input())
A = [0, 0, 0, 0]
B = [0, 0, 0, 0]
C = [0, 0, 0, 0]

for i in range(n):
    a, b, c = map(int, input().split())
    
    A[0] += a
    A[4 - a] += 1
    B[0] += b
    B[4 - b] += 1
    C[0] += c
    C[4 - c] += 1
    
def custom_max(a, b, c):
    max_value = max(a, b, c)
    if max_value == a and max_value == b or max_value == b and max_value == c or max_value == c and max_value == a:
        return 0
    
    elif max_value == a:
        return 1
    
    elif max_value == b:
        return 2
    
    elif max_value == c:
        return 3
        
print(custom_max(A, B, C), max(A[0], B[0], C[0])) 