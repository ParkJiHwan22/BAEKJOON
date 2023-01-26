while True:
    sentence = input()
    if sentence == '.':
        break

    balance_list = []
    for i in sentence:
        if i not in '()[]':
            continue

        if i == '(' or i == '[':
            balance_list.append(i)

        elif (i == ')' and balance_list and balance_list[-1] == '(') or (i == ']' and balance_list and balance_list[-1] == '['):
            balance_list.pop()

        else:
            balance_list.append(0)
            break

    print('no' if balance_list else 'yes')
