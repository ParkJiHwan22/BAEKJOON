loop = int(input())

for i in range(loop):
    num, format = map(int, input().split())
    result = ""
    
    while num > 0:
        tmpLeft = num % format
        if tmpLeft > 9:
            tmpLeft = chr(55 + tmpLeft)
        result = str(tmpLeft) + result
        num //= format
        
    if result == result[::-1]:
        print(1)
    else:
        print(0)