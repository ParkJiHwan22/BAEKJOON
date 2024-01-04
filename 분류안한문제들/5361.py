A = 350.34
B = 230.90
C = 190.55
D = 125.30
E = 180.90

n = int(input())

for i in range(n):
    a, b, c, d, e = map(int, input().split())
    total = A*a + B*b + C*c + D*d + E*e
    print(f'${total:.2f}')