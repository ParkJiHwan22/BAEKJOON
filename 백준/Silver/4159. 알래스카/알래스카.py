
while True:
    n = int(input())
    if n == 0:
        break
    else:
        station = [int(input()) for _ in range(n)]
        imp = 0
        station = sorted(station)

        for i in range(len(station)-1):
            if station[i] + 200 < station[i+1]:
                imp += 1
                break

        if (1422 - station[-1]) > 100:
            imp +=1

        if imp == 0:
            print('POSSIBLE')
        else:
            print('IMPOSSIBLE')