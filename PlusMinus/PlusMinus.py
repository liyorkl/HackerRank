import math
import os
import random
import re
import sys

#
# Complete the 'plusMinus' function below.
#
# The function accepts INTEGER_ARRAY arr as parameter.
#


def plusMinus(arr):
    # Write your code here
    length = len(arr)
    num_p = 0
    num_n = 0
    num_z = 0
    for i in arr:
        if i > 0:
            num_p += 1
        elif i < 0:
            num_n += 1
        else:
            num_z += 1
    print(f"{num_p/length:.6f}")
    print(f"{num_n/length:.6f}")
    print(f"{num_z/length:.6f}")


if __name__ == "__main__":
    n = int(input().strip())

    arr = list(map(int, input().rstrip().split()))

    plusMinus(arr)
