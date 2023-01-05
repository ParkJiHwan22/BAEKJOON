sts = []

for i in range(1,31):
    sts.append(i)

for i in range(28):
    att = (int(input()))
    sts.remove(att)

print(min(sts))
print(max(sts))