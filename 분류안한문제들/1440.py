nums = input().split(':')
hour = ['01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12']
cnt = 0

for i in nums:
    if int(i[0]) < 6:
        if i in hour:
            cnt += 1
    else:
        cnt = 0
        break
        
print(cnt*2)
