# 10699 오늘 날짜
# 문제
# 서울의 오늘 날짜를 출력하는 프로그램을 작성하시오.

# 입력
# 입력은 없다.

# 출력
# 서울의 오늘 날짜를 "YYYY-MM-DD" 형식으로 출력한다.

import time

now = time.strftime('%Y-%m-%d', time.localtime(time.time()))
print(now)

# 예제 입력 1 
# 예제 출력 1 
# 2015-01-24