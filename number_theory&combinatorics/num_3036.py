# 링
# 문제
# 상근이는 창고에서 링 N개를 발견했다. 상근이는 각각의 링이 앞에 있는 링과 뒤에 있는 링과 접하도록 바닥에 내려놓았다. 



# 상근이는 첫 번째 링을 돌리기 시작했고, 나머지 링도 같이 돌아간다는 사실을 발견했다. 나머지 링은 첫 번째 링 보다 빠르게 돌아가기도 했고, 느리게 돌아가기도 했다. 이렇게 링을 돌리다 보니 첫 번째 링을 한 바퀴 돌리면, 나머지 링은 몇 바퀴 도는지 궁금해졌다.

# 링의 반지름이 주어진다. 이때, 첫 번째 링을 한 바퀴 돌리면, 나머지 링은 몇 바퀴 돌아가는지 구하는 프로그램을 작성하시오.

# 입력
# 첫째 줄에 링의 개수 N이 주어진다. (3 ≤ N ≤ 100)

# 다음 줄에는 링의 반지름이 상근이가 바닥에 놓은 순서대로 주어진다. 반지름은 1과 1000를 포함하는 사이의 자연수이다.

# 출력
# 출력은 총 N-1줄을 해야 한다. 첫 번째 링을 제외한 각각의 링에 대해서, 첫 번째 링을 한 바퀴 돌리면 그 링은 몇 바퀴 도는지 기약 분수 형태 A/B로 출력한다.

import fractions

N = int(input())
ring = list(map(int, input().split()))
for i in range(1,N):
    if ring[0] % ring[i] == 0: # n/1의 형태로 나타날 때
        print(int(ring[0]/ring[i]), end = '') # 함수를 찢어서 표현 n <~~> /1
        print('/1')
    else: 
        print(fractions.Fraction(ring[0], ring[i])) # Fraction을 활용


# 최소공배수를 진짜 잘 이용한다. 8과 12의 최소공배수는 4이므로 {8/4}/{12/4} 이런 식으로 표현하는건 정말 멋지다.
# import math

# N = int(input())
# Rings = list(map(int, input().split()))

# for i in range(1,N):
#     Gcd = math.gcd(Rings[0], Rings[i])
#     print(f"{Rings[0]//Gcd}/{Rings[i]//Gcd}")


# 예제 입력 1 
# 3
# 8 4 2
# 예제 출력 1 
# 2/1
# 4/1

# 예제 입력 2 
# 4
# 12 3 8 4
# 예제 출력 2 
# 4/1
# 3/2
# 3/1

# 예제 입력 3 
# 4
# 300 1 1 300
# 예제 출력 3 
# 300/1
# 300/1
# 1/1