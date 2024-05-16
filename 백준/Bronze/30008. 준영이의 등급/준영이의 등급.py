N, K = map(int, input().split())

score = list(map(int, input().split()))
for j in score:
    j = j * 100 // N

    if j <= 4:
        print(1, end=" ")
    elif j <= 11:
        print(2, end=" ")
    elif j <= 23:
        print(3, end=" ")
    elif j <= 40:
        print(4, end=" ")
    elif j <= 60:
        print(5, end=" ")
    elif j <= 77:
        print(6, end=" ")
    elif j <= 89:
        print(7, end=" ")
    elif j <= 96:
        print(8, end=" ")
    elif j <= 100:
        print(9, end=" ")
