# 네 번째 점
# 문제
# 세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.

# 입력
# 세 점의 좌표가 한 줄에 하나씩 주어진다. 좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.

# 출력
# 직사각형의 네 번째 점의 좌표를 출력한다.

x1, y1 = map(int, input().split())
x2, y2 = map(int, input().split())
x3, y3 = map(int, input().split())

if x1 == x2 and y2 == y3:
    print(x3, y1, sep=' ')
elif x1 == x2 and y1 == y3:
    print(x3, y2, sep=' ')
elif x1 == x3 and y2 == y3:
    print(x2, y1, sep=' ')
elif x1 == x3 and y1 == y2:
    print(x2, y3, sep=' ')    
elif x2 == x3 and y1 == y3:
    print(x1, y2, sep=' ')
elif x2 == x3 and y1 == y2:
    print(x1, y3, sep=' ')






# 예제 입력 1 
# 5 5
# 5 7
# 7 5
# 예제 출력 1 
# 7 7

# 예제 입력 2 
# 30 20
# 10 10
# 10 20
# 예제 출력 2 
# 30 10