def korean_2(word):
    return ord(word) - ord('가') + 1

if __name__ == "__main__":
    word = input()
    print(korean_2(word))