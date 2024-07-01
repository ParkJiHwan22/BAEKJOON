t = int(input())
for _ in range(t):
    input()
    n, m = map(int, input().split())
    a = sorted(list(map(int, input().split())), reverse=True)
    b = sorted(list(map(int, input().split())), reverse=True)
    
    while a and b:
        if a[-1] >= b[-1]:
            b.pop()
        else:
            a.pop()
    
    if a:
        print('S')
    elif b:
        print('B')
    else:
        print('C')