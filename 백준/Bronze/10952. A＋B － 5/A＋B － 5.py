while (1 == 1) : # 1만 적어도 됨
    A, B = map(int, input().split())
    if (A==0 and B==0):
        break

    print(A+B)