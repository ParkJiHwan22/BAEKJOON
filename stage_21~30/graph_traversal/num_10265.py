# 10265 MT
# 문제
# 남규는 동기들과 엠티를 가기 위해 버스를 대절했다. 그런데 과사의 실수로 대절버스의 인원이 잘못되어 남규의 동기들을 모두 태울 수 없었다. 
# 이 와중에 동기들은 화를 내며 다음과 같은 말들을 주고받았다.

# 재혁: 동우가 안 가면 나도 안 간다.
# 동우: 세종이가 안 가면 난 안 갈래.
# 버스에 태울 수 있는 인원수는 한정되어 있는데 모두들 다른 누군가가 가지 않으면 자신도 가지 않겠다 하니 남규는 신경이 뻗쳤다. 게다가 술을 너무 많이 샀기 때문에 최대한 
# 많은 인원을 데려가지 않으면 안 되는 상황이었다.

# 각 사람이 원하는 같이 갈 사람이 주어질 때, 버스에 태울 수 있는 사람은 최대 몇 명인지 알아내시오.

# 입력
# 첫 번째 줄에 사람 수 n과 버스에 태울 수 있는 사람 수 k가 주어진다. (1 ≤ k ≤ n ≤ 1 000)

# 두 번째 줄에 n개의 정수 xi (i = 1, 2, ... , n, 1 ≤ xi ≤ n) 가 순서대로 주어진다. xi는 xi번째 사람이 버스에 타지 않는다면 i번째 사람 역시 버스에 타지 않음을 의미한다.

# 출력
# 모든 사람의 의견을 해치지 않고 최대한 태울 수 있는 인원수를 출력하시오.

import sys

n, k = map(int, sys.stdin.readline().split())
relation = list(map(int, sys.stdin.readline().split()))
visited = [[0] for _ in range(n+1)]
v_dict = {}

for num, node in enumerate(relation):
    v_dict[node] = num + 1

print(v_dict)

for i in v_dict:
        tmp = []
        tmp.append(i)
        key = i
        while True:
            try:
                if v_dict[key] not in tmp:
                    tmp.append(v_dict[key])
                    key = v_dict[key]
                else:
                    break
            except:
                break
    
        print(tmp)





# 예제 입력 1 
# 4 4
# 1 2 3 4
# 예제 출력 1 
# 4
# 예제 입력 2 
# 12 3
# 2 3 4 5 6 7 4 7 8 8 12 12
# 예제 출력 2 
# 2
# 예제 입력 3 
# 5 4
# 2 3 1 5 4
# 예제 출력 3 
# 3
