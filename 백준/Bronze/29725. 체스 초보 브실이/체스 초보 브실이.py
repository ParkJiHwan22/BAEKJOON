chess = {
    ".": 0,
    "k": 0,
    "K": 0,
    "p": -1,
    "P": 1,
    "n": -3,
    "N": 3,
    "b": -3,
    "B": 3,
    "r": -5,
    "R": 5,
    "q": -9,
    "Q": 9
}

score = 0
for i in range(8):
    word = input()

    for w in word:
        score += chess[w]

print(score)