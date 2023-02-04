import itertools

short = [int(input()) for i in range(9)]
real = list(itertools.combinations(short, 7))

for x in real:
    if sum(x) == 100:
        print(*sorted(x), sep = '\n')
        break