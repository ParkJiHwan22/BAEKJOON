while True:
    num = input()

    if num == '0':
        break
    
    total = 2
    for i in num:
        if i == '1':
            total += 2
        elif i == '0':
            total += 4
        else:
            total += 3

    print(total + len(num) - 1)