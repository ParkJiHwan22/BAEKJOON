while True:
    try:
        m, p, l, e, r, s, n = map(int, input().split())
        for i in range(n):
            sum_m = m
            m = p // s
            p = l // r
            l = sum_m * e
        print(m)
    except EOFError:
        break