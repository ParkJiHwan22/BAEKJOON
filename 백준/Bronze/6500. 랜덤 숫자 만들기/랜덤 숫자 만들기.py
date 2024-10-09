while True:
    n = input().strip()
    if n == "0":
        break

    a0 = int(n)
    seen = set()
    count = 0
    current = a0

    while current not in seen:
        seen.add(current)
        count += 1
        squared = str(current ** 2).zfill(8)
        current = int(squared[2:6])

    print(count)