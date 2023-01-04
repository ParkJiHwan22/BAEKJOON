N = int(input())
count = 0

a, b = N // 10, N % 10
c = a + b
count += 1
c = b * 10 + c % 10

while (1):
    if N == c:
        print(count)
        break

    else:
        d = 0
        count += 1
        c = str(c)
        for element in c:
            d += int(element)
        c = int(c)
        c = c % 10 * 10 + d % 10