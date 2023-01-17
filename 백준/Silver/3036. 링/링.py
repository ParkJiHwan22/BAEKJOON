import fractions

N = int(input())
ring = list(map(int, input().split()))
for i in range(1,N):
    if ring[0] % ring[i] == 0:
        print(int(ring[0]/ring[i]), end = '')
        print('/1')
    else:
        print(fractions.Fraction(ring[0], ring[i]))