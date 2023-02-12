N, r, c = map(int, input().split())

visited = 0

while N >= 1:

    N -= 1

    if r >= 2**N and c >= 2**N: 
        visited += ((2**N)**2)*3
        r = r - 2**N
        c = c - 2**N
    elif r >= 2**N and c < 2**N:
        visited += ((2**N)**2)*2
        r = r - 2**N
    elif r <2**N and c >= 2**N:
        visited += ((2**N)**2)
        c = c - 2**N
        
print(visited)

# def cut(n, arr):
#     cnt = 0
#     if n >= 2:
#         for i in range(0, 2**N, 2**(N-1)):
#             for j in range(0, 2**N, 2**(N-1)):
#                 for x in range(i, i + 2**(N-1)):
#                     for y in range(j, j + 2**(N-1)):
#                         for a in range(0, 2):
#                             arr[x][y] = cnt
#                             cnt + 1