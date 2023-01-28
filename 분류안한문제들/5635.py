# 5635 생일
# 문제
# 어떤 반에 있는 학생들의 생일이 주어졌을 때, 가장 나이가 적은 사람과 가장 많은 사람을 구하는 프로그램을 작성하시오.

# 입력
# 첫째 줄에 반에 있는 학생의 수 n이 주어진다. (1 ≤ n ≤ 100)

# 다음 n개 줄에는 각 학생의 이름과 생일이 "이름 dd mm yyyy"와 같은 형식으로 주어진다. 이름은 그 학생의 이름이며, 최대 15글자로 이루어져 있다. dd mm yyyy는 생일 일, 월, 연도이다. 
# (1990 ≤ yyyy ≤ 2010, 1 ≤ mm ≤ 12, 1 ≤ dd ≤ 31) 주어지는 생일은 올바른 날짜이며, 연, 월 일은 0으로 시작하지 않는다.

# 이름이 같거나, 생일이 같은 사람은 없다.

# 출력
# 첫째 줄에 가장 나이가 적은 사람의 이름, 둘째 줄에 가장 나이가 많은 사람 이름을 출력한다.

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

# 무턱대고 리스트로 받아버린게 복잡해진 원인
#-------------------------------------------
import sys
input = sys.stdin.readline

lst = []
for _ in range(int(input())):
    n,d,m,y = input().rstrip().split() # n,d,m,y를 따로 보는게 좋은 방법
    d,m,y = map(int,(d,m,y)) # map을 d,m,y에 따로 설정해줄 수가 있었음
    lst.append((y,m,d,n)) 
lst.sort()
print(lst[-1][3])
print(lst[0][3])

# 예제 입력 1 
# 5
# Mickey 1 10 1991
# Alice 30 12 1990
# Tom 15 8 1993
# Jerry 18 9 1990
# Garfield 20 9 1990


# 예제 출력 1 
# Tom
# Jerry