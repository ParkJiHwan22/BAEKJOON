V = int(input())
vote = input()

cnt = 0
for i in vote:
    if i == 'A':
        cnt += 1
    else:
        cnt -= 1

if cnt > 0:
    print('A')
elif cnt < 0:
    print('B')
else:
    print('Tie')