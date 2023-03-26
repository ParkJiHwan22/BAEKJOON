n = int(input())

cnt, bird = 0, 1
while n > 0:
    if n >= bird:
        n = n - bird
        bird += 1
        cnt += 1
    
    else:
        bird = 1
        n = n - bird
        bird += 1
        cnt += 1

print(cnt)