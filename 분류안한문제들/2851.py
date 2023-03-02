res = []
nums = [int(input()) for _ in range(10)]

end = 1
while end <= 10:
    if sum(nums[:end]) > 100:
        res.append(sum(nums[:end]))
        break
    
    elif sum(nums[:end]) < 100:
        res.append(sum(nums[:end]))
        end += 1
        
    else:
        res.append(sum(nums[:end]))
        break
    
if len(res) == 1:
    print(res[0])
elif res[-1] > 100:
    if res[-1] - 100 <= 100 - res[-2]:
        print(res[-1])
    else:
        print(res[-2])
else:
    print(res[-1])