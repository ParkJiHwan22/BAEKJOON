N = int(input())
cnt = 0

for i in range(N):
    vote = int(input())
    if vote == 1:
        cnt += 1
    else:
        cnt -= 1

if cnt > 0:
    print("Junhee is cute!")
else:
    print("Junhee is not cute!")
