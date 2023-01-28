start = input()
cnt = 0

if start == '고무오리 디버깅 시작':
    while True:
        command = input()
        if command == '문제':
            cnt += 1
        elif command == '고무오리':
            if cnt == 0:
                cnt += 2
            else:
                cnt -= 1
        elif command == '고무오리 디버깅 끝':
            break

if cnt == 0:
    print('고무오리야 사랑해')
else:
    print('힝구')