h, m = map(int, input().split())
time = input()

h += int(time) // 60
m += int(time) % 60

if m >= 60:
    h += 1
    m -= 60

    if h >= 24:
        h -= 24
        
    print(h, m)

else:
    if h >= 24:
        h -= 24
        
    print(h, m)   