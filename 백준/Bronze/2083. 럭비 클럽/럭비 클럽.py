while True:
    words = list(input().split())
    if words[1] == '0' and words[2] == '0':
        break
    elif int(words[1]) <= 17 and int(words[2]) < 80:
        print(words[0], 'Junior')
    else:
        print(words[0], 'Senior')