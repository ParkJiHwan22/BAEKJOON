N, X = map(int, input().split())
A = input().split()
B = list()


for element in A:
    if int(element) < X:
        print(element, end=" ")