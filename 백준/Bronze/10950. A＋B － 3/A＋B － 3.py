T = int(input())
list_1 = list()

for i in range(1, T+1):
    a,b = map(int, input().split())
    list_1.append(a+b)

for i in list_1:
    print(i)