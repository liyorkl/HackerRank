import random


f = open("test/findRemainingAsteroids/input.txt", "w")

n = random.randint(1, 1000)

s = f"{n}\n"

for i in range(n):
    ranint = random.randint(1, pow(10, 9))
    s += f"{ranint}\n"

s += f"{n}\n"

for i in range(n):
    ranint = random.randint(0, 1)
    s += f"{ranint}\n"

f.write(s)