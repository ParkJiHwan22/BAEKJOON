# 문제
# 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 
# 단, 대문자와 소문자를 구분하지 않는다.

# 입력
# 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.

# 출력
# 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다.
# 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.

'''
word = input() # ASCII code : A~Z = 65~90, a~z = 97~122
lst = []

for i in word: # 대, 소문자 구분없이 전부 0~25의 숫자로 변환
    if ord(i) > 96:
        lst.append(ord(i) - 97)
    elif ord(i) > 64:
        lst.append(ord(i) - 65)

lst.sort() # 크기 순대로 정리
cnt = 0
dict_num = {} # 알파벳-개수
k = lst[0] 

for i in lst: # 알파벳-개수, 를 키-값 구조로 변경해서 dict_num에 넣음
    if i == k:
        cnt += 1
        dict_num[i] = cnt
        k = i
    else:
        cnt = 1
        dict_num[i] = cnt
        k = i

# print(dict_num) # {8: 4, 12: 1, 15: 1, 18: 4}

sum = 0
f = 0
alphabet = 0

for i in dict_num:
    if dict_num[i] > sum:
        sum = dict_num[i]
        alphabet = i + 65 # ASCII code, 알파벳 대문자로 변환하기 위한 준비
        f = 0
    elif dict_num[i] == sum:
        sum = 1
        f += 1

if f >= 1:
    print("?")
else:
    print(chr(alphabet)) # ASCII code, 알파벳 대문자로 변환하고 출력
'''

word = input().upper() # upper : 문자열을 대문자로 변경
word_list = list(set(word))  # set : 입력받은 문자열에서 중복값을 제거
                             # word_list = Mississipi,  ['I', 'S', 'P', 'M']
cnt_list = []
for x in word_list:
    cnt = word.count(x)
    cnt_list.append(cnt)  # count 숫자를 리스트에 append
                          # cnt_list = Mississipi, [4, 1, 1, 4]


if cnt_list.count(max(cnt_list)) > 1 :  # count 숫자 최대값이 중복되면
    print('?')
else :
    max_index = cnt_list.index(max(cnt_list))  # count 숫자 최대값 인덱스(위치)
    print(word_list[max_index])

# 더 많은 함수를 익히고 사용할 줄 알아야할 것 같다. 많이 생각해봤지만 지금 아는 함수로는 부족하다.ㄴ

# 예제 입력 1 
# Mississipi
# 예제 출력 1 
# ?

# 예제 입력 2 
# zZa
# 예제 출력 2 
# Z

# 예제 입력 3 
# z
# 예제 출력 3 
# Z

# 예제 입력 4 
# baaa
# 예제 출력 4
# A