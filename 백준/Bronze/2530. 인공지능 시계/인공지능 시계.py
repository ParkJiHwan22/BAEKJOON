time = list(map(int, input().split()))
second = int(input())

if (time[2] + second) // 60 > 0:
    time[1] += (time[2] + second) // 60
    time[2] = (time[2] + second) % 60
    if  time[1] // 60 > 0:
        time[0] += time[1] // 60
        time[1] = time[1] % 60
        time[0] = time[0] % 24
else:
    time[2] = time[2] + second

print(time[0], time[1], time[2])