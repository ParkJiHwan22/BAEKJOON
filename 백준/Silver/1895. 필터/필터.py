R, C = map(int, input().split())
image = [list(map(int, input().split())) for _ in range(R)]


filtering_image = []
for i in range(R-2):
    for j in range(C-2):
        filtering = []
        for x in range(i, i+3):
            for y in range(j, j+3):
               filtering.append(image[x][y])
            
        filtering_image.append(sorted(filtering)[4])


T = int(input())

cnt = 0
for k in filtering_image:
    if k >= T:
        cnt += 1

print(cnt)
