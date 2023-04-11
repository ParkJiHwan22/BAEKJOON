T = int(input())

for i in range(T):
    square = [list(map(int, input().split())) for _ in range(4)]
    
    res = []
    for n in range(4):
        res.append((square[n][0] - square[0][0]) ** 2 + (square[n][1] - square[0][1]) ** 2)
        
        
    a = max(res)
    res = []
    for n in range(4):
        res.append((square[n][0] - square[1][0]) ** 2 + (square[n][1] - square[1][1]) ** 2)
        
    b = max(res)

    res = []
    for n in range(4):
        res.append((square[n][0] - square[2][0]) ** 2 + (square[n][1] - square[2][1]) ** 2)
        
    c = max(res)
    
    
    # if a == b == c and d == e == f and a != d and b != e and c != f:
    #     print(1)
    # else:
    #     print(0)           
