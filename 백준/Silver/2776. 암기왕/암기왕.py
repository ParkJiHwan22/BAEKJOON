import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    n = int(input())
    num_lst = sorted(list(map(int, input().split())))

    m = int(input())
    watch_lst = list(map(int, input().split()))

    for num in watch_lst:
        left, right = 0, n - 1
        found = False

        # 리스트의 크기가 2 이하일 경우
        if len(num_lst) <= 2:
            if num in num_lst:
                print(1)
            else:
                print(0)
            continue

        # 이진 탐색 수행
        while left <= right:
            mid = (left + right) // 2

            if num_lst[mid] == num:
                print(1)
                found = True
                break
            elif num_lst[mid] > num:
                right = mid - 1
            else:
                left = mid + 1

        if not found:
            print(0)