score_list = [0]*5

for i in range(5):
    score = list(map(int, input().split()))
    score_list[i] = sum(score)

if score_list.count(max(score_list)) == 1:
    print(score_list.index(max(score_list))+1, max(score_list))