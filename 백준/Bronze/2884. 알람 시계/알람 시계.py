a, b = map(int, input().split())

if a == 0 and b < 45:
    a += 23
    b += 15
    print(a, b)
elif b < 45:
    a -= 1
    b += 15
    print(a, b)
else:
     b -= 45
     print(a, b)