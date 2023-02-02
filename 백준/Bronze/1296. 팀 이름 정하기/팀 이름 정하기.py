from itertools import combinations

name = input()
n = int(input())
team_list = [input() for _ in range(n)]

score_dict = {
    'L' : 0,
    'O' : 0,
    'V' : 0,
    'E' : 0
}
res = {}

for team in team_list:
    for x in name:
        if x in score_dict:
            score_dict[x] += 1
    for y in team:
        if y in score_dict:
            score_dict[y] += 1

    score = 1
    score_list = list(combinations(score_dict.values(), 2))
    
    for score_tuple in score_list:
        score *= (score_tuple[0]+score_tuple[1])
    
    res[team] = score % 100

    for x in score_dict:
        score_dict[x] = 0

res = sorted(res.items(), key=lambda x: x[1], reverse = True)

real_res = []
for i in range(len(res)):
    if res[0][1] == res[i][1]:
        real_res.append(res[i][0])
    else:
        break

real_res = sorted(real_res)
print(real_res[0])