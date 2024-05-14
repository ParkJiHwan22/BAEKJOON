code = input()
n = int(input())
cnt = 0

for i in range(n):
    re_code = input()
    if code[0:5] == re_code[0:5]:
        cnt += 1

print(cnt)