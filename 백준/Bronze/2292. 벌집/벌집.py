N = int(input())
n = 0
sum = 1

while True:
    n += 1
    bee = 6*(n-1)
    sum += bee
    if sum >= N:
        print(n)
        break
    else:
        continue