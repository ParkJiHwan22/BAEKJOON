
while True:
    words = input().lower()
    if words == '#':
        break
    
    cnt = - 1
    for i in words:
        if words[0] == i:
            cnt += 1
            
    print(words[0], cnt)