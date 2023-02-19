cnt = 0
while True:
    l, p, v = map(int, input().split())
    if l == p == v == 0:
        break
    else:
        total = 0
        cnt += 1
        
        total += (v // p) * l
        if (v % p) >= l:
            total += l
        else:
            total += (v % p)
        
        print(f'Case {cnt}: {total}')