T = int(input())
list_hex = []
k = 0
n = 0

for i in range(6):
    lst = list(map(int, input().split()))
    list_hex.append(lst[1])
    if lst[1] >= k:
        k = lst[1]
        n = i


if list_hex[(1+n)%6] >= list_hex[(5+n)%6]:
     print(((list_hex[(1+n)%6]*list_hex[n%6])-(list_hex[(3+n)%6]*list_hex[(4+n)%6]))*T)
else:
    print(((list_hex[n%6]*list_hex[(5+n)%6])-(list_hex[(2+n)%6]*list_hex[(3+n)%6]))*T)