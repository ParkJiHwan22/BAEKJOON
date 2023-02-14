import sys
n = int(sys.stdin.readline())
rooms = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
room_dict = {}

for room in rooms:
    if room[0] != room[1]:
        if room[0] in room_dict:
            if room[1] < room_dict[room[0]]:
                room_dict[room[0]] = room[1]
        else:
            room_dict[room[0]] = room[1]

room_list = sorted(room_dict.items())

for j in range(n):
    if rooms[j][0] == rooms[j][1]:
        room_list.append((rooms[j][0], rooms[j][1]))

room_list = sorted(room_list, key=lambda x: (x[1], x[0]))

now, cnt = 0, 0
for i in range(len(room_list)):
    if now <= room_list[i][0]:
        cnt += 1
        now = room_list[i][1]

print(cnt)