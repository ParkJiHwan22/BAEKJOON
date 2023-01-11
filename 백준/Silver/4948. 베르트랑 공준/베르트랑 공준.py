while True:
    n = int(input())
    if n == 0:
        break

    cnt = 0
    prime_num = 0

    for i in range(n+1, 2*n+1):
        cnt = 0
        for j in range(2,int(i**0.5)+1):
            if i % j == 0:
                cnt += 1
                break
        if cnt == 0:
            prime_num += 1

    print(prime_num)