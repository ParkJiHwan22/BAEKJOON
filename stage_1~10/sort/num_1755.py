# # 1775 숫자놀이
# # 문제
# # 79를 영어로 읽되 숫자 단위로 하나씩 읽는다면 "seven nine"이 된다. 80은 마찬가지로 "eight zero"라고 읽는다. 
# # 79는 80보다 작지만, 영어로 숫자 하나씩 읽는다면 "eight zero"가 "seven nine"보다 사전순으로 먼저 온다.

# # 문제는 정수 M, N(1 ≤ M ≤ N ≤ 99)이 주어지면 M 이상 N 이하의 정수를 숫자 하나씩 읽었을 때를 기준으로 사전순으로 정렬하여 출력하는 것이다.

# # 입력
# # 첫째 줄에 M과 N이 주어진다.

# # 출력
# # M 이상 N 이하의 정수를 문제 조건에 맞게 정렬하여 한 줄에 10개씩 출력한다.

m, n = map(int, input().split())
change_dict = {'0': 'zero', '1': 'one', '2': 'two', '3': 'three', '4': 'four',
               '5': 'five', '6': 'six', '7': 'seven', '8': 'eight', '9': 'nine'}

strs = [[] for i in range(n+1)]

num_dict = {}
for i in range(m, n+1):
    for j in str(i):
        strs[i].append(change_dict[j])

    strs[i] = ' '.join(strs[i])
    num_dict[strs[i]] = i

result = sorted(num_dict.items())

for j in range(len(result)):
    if (j+1) % 10 == 0:
        print(result[j][1])
    else:
        print(result[j][1], end = ' ')

# #==============================================

# d = {'1':'one', '2':'two', '3':'three', '4':'four', '5':'five', 
#      '6':'six', '7':'seven', '8':'eight', '9':'nine', '0':'zero'}

# M, N = map(int, input().split())
# li = []

# for i in range(M, N+1):
#     s = ' '.join([d[c] for c in str(i)])
#     li.append([i, s])

# li.sort(key=lambda x:x[1])
# for i in range(len(li)):
#     if i%10 == 0 and i!= 0:
#         print()
#     print(li[i][0], end=' ')



# # 예제 입력 1 
# # 8 28

# # 예제 출력 1 
# # 8 9 18 15 14 19 11 17 16 13
# # 12 10 28 25 24 21 27 26 23 22
# # 20