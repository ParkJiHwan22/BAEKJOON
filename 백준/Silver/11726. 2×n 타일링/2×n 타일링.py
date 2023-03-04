n = int(input())

a = 1
b = 2

if n == 1:
    print(1)
elif n == 2:
    print(2)
else:    
    for i in range(n-2):
        c = a + b
        a = b
        b = c
    
    print(c%10007)
        