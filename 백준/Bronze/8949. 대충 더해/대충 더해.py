a, b = input().split()

length = abs(len(a) - len(b))

if len(a) < len(b):
    a = ("0" * length) + a
elif len(a) > len(b):
    b = ("0" * length) + b

res = ""
for i in range(len(a)):
    res += str(int(a[i]) + int(b[i]))

print(res)