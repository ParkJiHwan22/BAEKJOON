n = int(input())

chang = 100
sang = 100
for i in range(n):
    a, b = map(int, input().split())
    if a > b:
        sang = sang - a
    elif a < b:
        chang = chang - b
    
print(chang, sang, sep='\n')
    