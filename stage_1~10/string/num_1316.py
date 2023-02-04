# 그룹 단어 체커
# 문제
# 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 
# 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, 
# aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.

# 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.

# 입력
# 첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 단어가 들어온다. 
# 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.

# 출력
# 첫째 줄에 그룹 단어의 개수를 출력한다.

# N = int(input())
# word_list = []
# dict_word = {}
# cnt = 0
# sum = 0

# for i in range(N):
#     word = input()
#     word_list.append(word)

# for i in word_list:
#     k = ''
#     for j in i:
#         if j in dict_word:
#             if k == j:
#                 dict_word[j] += 1
#                 k = j
#             else:
#                 cnt += 1
#         else:
#             dict_word[j] = 1
#             k = j

#     if cnt == 0:
#         sum += 1
#         cnt = 0
#         dict_word.clear()
#     else:
#         cnt = 0
#         dict_word.clear()

# print(sum)

# 코드가 부끄러울 정도로 길다 여러 함수 메소드 사용해서 간략하게 생각하기\
# 참 깔끔하다

N = int(input())
result = N
for i in range(0,N):
    word=input()
    for j in range(0,len(word)-1): # range(0, len(word)-1)을 이용

        if word[j] == word[j+1]:
            pass
        elif word[j] in word[j+1:]:
            result -= 1
            break
print(result)


# 예제 입력 1 
# 3
# happy
# new
# year
# 예제 출력 1 
# 3

# 예제 입력 2 
# 4
# aba
# abab
# abcabc
# a
# 예제 출력 2 
# 1

# 예제 입력 3 
# 5
# ab
# aa
# aca
# ba
# bb
# 예제 출력 3 
# 4

# 예제 입력 4 
# 2
# yzyzy
# zyzyz
# 예제 출력 4 
# 0

# 예제 입력 5 
# 1
# z
# 예제 출력 5 
# 1