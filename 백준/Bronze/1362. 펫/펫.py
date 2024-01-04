import sys


class Pet:
    def __init__(self, o, w):
        self.o = o
        self.w = w
        self.is_alive = True

    def action(self, typeof, value):
        if typeof == 'F':
            self.w += value
        elif typeof == 'E':
            self.w -= value

        if self.w <= 0:
            self.is_alive = False

    def state(self):
        if not self.is_alive:
            return 'RIP'
        elif self.o * 0.5 < self.w < self.o * 2:
            return ':-)'
        else:
            return ':-('


if __name__ == '__main__':
    count = 0
    while True:
        o, w = map(int, input().split())
        if o == 0 and w == 0:
            break

        pet = Pet(o, w)
        count += 1

        while True:
            typeof, value = sys.stdin.readline().split()
            if typeof == '#' and value == '0':
                print(count, pet.state())
                break

            pet.action(typeof, int(value))