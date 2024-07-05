ma = ""
mb = 0
for i in range(7):
    a, b = input().split()
    if (mb < int(b)):
      mb = int(b)
      ma = a

print(ma) 