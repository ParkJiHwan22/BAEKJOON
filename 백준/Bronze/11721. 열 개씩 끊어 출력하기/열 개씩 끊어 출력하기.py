sentence = input()
new_sen = ''
cnt = 0

for i in sentence:
    cnt += 1
    new_sen = new_sen + i
    if cnt == 10:
        print(new_sen)
        cnt = 0
        new_sen = ''

print(new_sen)