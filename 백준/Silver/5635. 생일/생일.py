T = int(input())

name_list = [list(input().split())[::-1] for i in range(T)]
young_list = sorted(name_list, reverse=True)
print(young_list[0][3])

old_list = sorted(name_list)

month = 13
day = 32
for x in range(T):
    if old_list[0][0] == old_list[x][0]:
        if month > int(old_list[x][1]):
            month = int(old_list[x][1])
            old_man = old_list[x][3]
            if day > int(old_list[x][2]):
                day = int(old_list[x][2])
                old_man = old_list[x][3]
    else:
        break

print(old_man)