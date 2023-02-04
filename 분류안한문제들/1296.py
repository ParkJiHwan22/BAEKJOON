# # 1296 팀 이름 정하기
# # 문제
# # 연두는 프로그래밍 대회에 나갈 팀 이름을 정하려고 한다. 미신을 믿는 연두는 이환이에게 공식을 하나 받아왔고, 이 공식을 이용해 우승할 확률이 가장 높은 팀 이름을 찾으려고 한다.

# # 이환이가 만든 공식은 사용하려면 먼저 다음 4가지 변수의 값을 계산해야 한다.

# # L = 연두의 이름과 팀 이름에서 등장하는 L의 개수
# # O = 연두의 이름과 팀 이름에서 등장하는 O의 개수
# # V = 연두의 이름과 팀 이름에서 등장하는 V의 개수
# # E = 연두의 이름과 팀 이름에서 등장하는 E의 개수
# # 그 다음, 위에서 구한 변수를 다음 식에 입력하면 팀 이름의 우승할 확률을 구할 수 있다.

# # ((L+O) × (L+V) × (L+E) × (O+V) × (O+E) × (V+E)) mod 100

# # 연두의 영어 이름과 팀 이름 후보 N개가 주어졌을 때, 우승할 확률이 가장 높은 팀 이름을 구해보자. 확률이 가장 높은 팀이 여러가지인 경우 사전 순으로 가장 앞서는 팀 이름이 우승할 확률이 가장 높은 것이다.

# # 입력
# # 첫째 줄에 연두의 영어 이름이 주어진다. 둘째 줄에는 팀 이름 후보의 개수 N이 주어진다. 셋째 줄부터 N개의 줄에 팀 이름이 한 줄에 하나씩 주어진다.

# # 연두의 영어 이름과 팀 이름은 길이는 1보다 크거나 같고, 20보다 작거나 같으며, 알파벳 대문자로만 이루어져 있다. N은 50보다 작거나 같은 자연수이다.

# # 출력
# # 첫째 줄에 우승할 확률이 가장 높은 팀 이름을 출력한다.

# from itertools import combinations

# name = input()
# n = int(input())
# team_list = [input() for _ in range(n)]

# score_dict = {
#     'L' : 0,
#     'O' : 0,
#     'V' : 0,
#     'E' : 0
# }
# res = {}

# for team in team_list:
#     for x in name:
#         if x in score_dict:
#             score_dict[x] += 1
#     for y in team:
#         if y in score_dict:
#             score_dict[y] += 1

#     score = 1
#     score_list = list(combinations(score_dict.values(), 2))
    
#     for score_tuple in score_list:
#         score *= (score_tuple[0]+score_tuple[1])
    
#     res[team] = score % 100

#     for x in score_dict:
#         score_dict[x] = 0

# res = sorted(res.items(), key=lambda x: x[1], reverse = True)

# real_res = []
# for i in range(len(res)):
#     if res[0][1] == res[i][1]:
#         real_res.append(res[i][0])
#     else:
#         break

# real_res = sorted(real_res)
# print(real_res[0])

# #===============================================================

name = input()
n = int(input())
team_list = sorted([input() for i in range(n)]) # 여기서 sorted 해줬으니까
max_p = max_i = 0

for i in range(n):
    L = name.count("L") + team_list[i].count("L") # count 썼으면 됐는데
    O = name.count("O") + team_list[i].count("O")
    V = name.count("V") + team_list[i].count("V")
    E = name.count("E") + team_list[i].count("E")
    p = ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100

    if max_p < p:
        max_p = p # 크면 바꾸면 되지만
        max_i = i # 같으면 그냥 첫번째 꺼로 가자

print(team_list[max_i])


# # 예제 입력 1 
# # LOVE
# # 3
# # JACOB
# # FRANK
# # DANO
# # 예제 출력 1 
# # FRANK

# # 예제 입력 2 
# # JANE
# # 4
# # THOMAS
# # MICHAEL
# # INDY
# # LIU
# # 예제 출력 2 
# # INDY

# # 예제 입력 3 
# # LILLY
# # 1
# # PIERRE
# # 예제 출력 3 
# # PIERRE

# # 예제 입력 4 
# # MERYLOV
# # 5
# # JOHN
# # DAVE
# # STEVE
# # JOHN
# # DAVE
# # 예제 출력 4 
# # DAVE

# # 예제 입력 5 
# # LLOL
# # 4
# # BVERON
# # CVERON
# # AVERON
# # DVERON
# # 예제 출력 5 
# # AVERON

# # 예제 입력 6 
# # VELYLEOCEVE
# # 5
# # YVXHOVE
# # LCOKO
# # OGWSJVEVEDLE
# # WGFVSJEL
# # VLOLUVCBLLQVESWHEEKC
# # 예제 출력 6 
# # VLOLUVCBLLQVESWHEEKC