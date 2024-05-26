import sys; input = sys.stdin.readline

while True:
    try:
        n = int(input())
    except:
        break

    appear = {'0': False, '1': False, '2': False, '3': False, '4': False, '5': False, '6': False, '7': False, '8': False, '9': False}
    rest = 10
    S = k = 0

    while rest:
        k += 1
        S += n
        for m in str(S):
            if not appear[m]:
                appear[m] = True
                rest -= 1
                if not rest:
                    break
    print(k)