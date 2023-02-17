# 1931 회의실 배정
# 문제
# 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 
# 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자. 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 
# 동시에 다음 회의가 시작될 수 있다. 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.

# 입력
# 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 
# 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.

# 출력
# 첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.

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

#=====================================================================

import sys

N = int(sys.stdin.readline())

time = [[0]*2 for _ in range(N)] # 딕셔너리 없이 미리 리스트를 만들어놓고 풀이함
for i in range(N):
    s, e = map(int, sys.stdin.readline().split())
    time[i][0] = s
    time[i][1] = e

time.sort(key = lambda x: (x[1], x[0]))

cnt = 1
end_time = time[0][1]
for i in range(1, N):
    if time[i][0] >= end_time:
        cnt += 1
        end_time = time[i][1]

print(cnt)

# 예제 입력 1 
# 11
# 1 4
# 3 5
# 0 6
# 5 7
# 3 8
# 5 9
# 6 10
# 8 11
# 8 12
# 2 13
# 12 14

# 예제 출력 1 
# 4