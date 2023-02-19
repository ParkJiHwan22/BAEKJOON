n = int(input())

cnt = 0
for x in range(2022, n+1):
    year_list = ['2', '0', '2', '3']
    for y in str(x):
        if y == year_list[0]:
            year_list.pop(0)
        
        if len(year_list) == 0:
            cnt += 1
            break

print(cnt)