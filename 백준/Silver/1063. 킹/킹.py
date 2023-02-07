king, stone, n = input().split()
k = []
s = []

for i in king:
    if i.isalpha() == 1:
        k.append(ord(i)-64)
    else:
        k.append(int(i))

for j in stone:
    if j.isalpha() == 1:
        s.append(ord(j)-64)
    else:
        s.append(int(j))

dxdy = {
    'R' : (0, 1),
    'RT' : (1, 1),
    'T' : (1, 0),
    'LT' : (1, -1),
    'L' : (0, -1),
    'LB' : (-1, -1),
    'B' : (-1, 0),
    'RB' : (-1, 1)
}

for _ in range(int(n)):
    command = input()
    if 1 <= k[0] + dxdy[command][1] <= 8 and 1 <= k[1] + dxdy[command][0] <= 8:
        k[0] = k[0] + dxdy[command][1]
        k[1] = k[1] + dxdy[command][0]

        if k[0] == s[0] and k[1] == s[1]:
            if 1 <= s[0] + dxdy[command][1] <= 8 and 1 <= s[1] + dxdy[command][0] <= 8:
                s[0] = s[0] + dxdy[command][1]
                s[1] = s[1] + dxdy[command][0]
            else:
                k[0] = k[0] - dxdy[command][1]
                k[1] = k[1] - dxdy[command][0]

print(chr(k[0]+64), k[1], sep = '')
print(chr(s[0]+64), s[1], sep = '')
