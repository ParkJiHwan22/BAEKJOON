year = input()

if int(year) % 4 == 0:
    if int(year) % 100 != 0 or int(year) % 400 == 0:
        print(1)
    else:
        print(0)

else:
    print(0)