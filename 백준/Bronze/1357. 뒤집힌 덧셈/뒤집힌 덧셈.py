
x, y = input().split()
res_x, res_y, res = '', '', ''

for i in x[::-1]:
    res_x += i

for j in y[::-1]:
    res_y += j

for k in str(int(res_x) + int(res_y))[::-1]:
    res += k
    
print(int(res))