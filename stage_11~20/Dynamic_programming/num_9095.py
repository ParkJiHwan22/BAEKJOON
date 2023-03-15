from math import factorial

T = int(input())

for _ in range(T):
    total = 0
    n = int(input())
    
    for i in range((n // 3)+1):
        t = n - (i*3)
        
        for j in range((t // 2)+1):
            total += factorial(i + (t - (j*2)) + j)//(factorial(i)*factorial(t - (j*2))*factorial(j))

    print(total)