h = []
b = []
res = []

for i in range(3):
    h.append(int(input()))

for i in range(2):
    b.append(int(input()))
    
for i in range(3):
    for j in range(2):
        res.append(h[i] + b[j] - 50)
        
print(min(res))