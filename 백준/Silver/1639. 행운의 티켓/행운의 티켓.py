import sys
input = sys.stdin.readline

num = list(map(int, input().strip()))
k = len(num) // 2
is_end = False

if len(num) % 2 == 1:
    while(k > 0 and is_end == False):
        for i in range((len(num)//2 - k) * 2 + 2):
            if (sum(num[i:k+i]) == sum(num[k+i:k*2+i])):
                is_end = True
                break

        k = k-1
else:
    while(k > 0 and is_end == False):
        for i in range((len(num)//2 - k) * 2 + 1):
            if (sum(num[i:k+i]) == sum(num[k+i:k*2+i])):
                is_end = True
                break

        k = k-1

if (is_end == False):
    print(0)
else:
    print((k+1)*2)