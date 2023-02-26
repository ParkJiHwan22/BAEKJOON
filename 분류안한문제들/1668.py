n = int(input())
nums = [int(input()) for _ in range(n)]

i_max, cnt = 0, 0
for i in nums:
    if i > i_max:
        i_max = i
        cnt += 1

j_max, cnt_2 = 0, 0
for j in range(len(nums)-1, -1, -1):
    if nums[j] > j_max:
        j_max = nums[j]
        cnt_2 += 1

print(cnt)
print(cnt_2)