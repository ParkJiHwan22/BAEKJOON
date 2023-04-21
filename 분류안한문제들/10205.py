n = int(input())

for num in range(1, n+1):
    head = int(input())
    action = input()

    for i in action:
        if head == 0:
            break
        elif i == 'b':
            head -= 1
        else:
            head += 1

    print(f'Data Set {num}:')
    print(head)
    print('')