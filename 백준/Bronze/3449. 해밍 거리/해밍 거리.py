n = int(input())

for i in range(n):
    cnt = 0
    a = input()
    b = input()
    
    for j in range(len(a)):
        if a[j] != b[j]:
            cnt += 1
            
    print('Hamming distance is ', cnt, '.', sep='')