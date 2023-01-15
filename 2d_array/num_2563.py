T = int(input())
lst_x = []
lst_y = []
sum = 0

for i in range(T):
    x, y = map(int, input().split())
    cnt = 0
    for i in range(x, x + 10):
        for j in range(y, y + 10):
            if i not in lst_x:
                lst_x.append(i)
                if j not in lst_y:
                    lst_y.append(j)
                    
            else:
                if j not in lst_y:
                    lst_y.append(j)
                else:
                    cnt += 1
    
    sum += 100 - cnt

print(sum)
            
