a, b = map(int, input().split())
total = []
tmp = 0

while len(total) <= 1000:
    tmp += 1
    for i in range(tmp):
        total.append(tmp)
        
print(sum(total[a-1:b]))