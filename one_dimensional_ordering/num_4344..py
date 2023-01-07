# 문제
# 대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.

# 입력
# 첫째 줄에는 테스트 케이스의 개수 C가 주어진다.

# 둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고,
#  이어서 N명의 점수가 주어진다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.

# 출력
# 각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.

a = 0 # 분자
b = 0 # 분모
cnt_z = 0
cnt = 0
cnt_t = -1 # 맨 첫번째 자리에 있는 수는 포함 안함


c = int(input())
for i in range(c):
    num = list(map(int, input().split()))

    for j in num:
        cnt_z += 1
        if cnt_z != 1:
            a += j
        else:
            b += j # 이 6줄이 이거라니... : avg = sum(nums[1:])/nums[0]

    for j in num:           # for score in nums[1:]:
        cnt_t += 1          #    if score > avg:
        if cnt_t != 0:      #        cnt += 1  # 평균 이상인 학생 수
            if j > a/b:
                cnt += 1


    print(f"{cnt*100/cnt_t:.3f}%")
    a = 0
    b = 0
    cnt_z = 0
    cnt = 0
    cnt_t = -1


# 리스트의 특성을 잘 활용하지 못했다 num[1:]과 같은 개념은 쉽고 유용해보인다. 앞으로 활용해야곘다!
'''
for _ in range(n):
    nums = list(map(int, input().split()))
    avg = sum(nums[1:])/nums[0]  # 평균을 구함 (nums[0]: 학생수, nums[1:] 점수)
    cnt = 0
    for score in nums[1:]:
        if score > avg:
            cnt += 1  # 평균 이상인 학생 수
    rate = cnt/nums[0] *100
    print(f'{rate:.3f}%')
'''







# print(f"{sup/cnt:.3f}%")
 
# 예제 입력 1 
# 5
# 5 50 50 70 80 100
# 7 100 95 90 80 70 60 50
# 3 70 90 80
# 3 70 90 81
# 9 100 99 98 97 96 95 94 93 91

# 예제 출력 1 
# 40.000%
# 57.143%
# 33.333%
# 66.667%
# 55.556%