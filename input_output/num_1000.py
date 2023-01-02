# 문제
# 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

# 입력
# 첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)

# 출력
# 첫째 줄에 A+B를 출력한다.

# A,B = int(input()), int(input())
# print(A + B)

a, b = input().split() # (a)

print(int(a) + int(b)) # (b)


''' 풀이
틀린 이유: input().split() split() 함수를 몰랐다.
풀이 아이디어 : input()의 공간을 split()으로 잘라서 두 공간을 만든다. 
input()안의 type은 str이므로 print에서 int로 변경하였다.
'''