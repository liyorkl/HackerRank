import math
import os
import random
import re
import sys

#
# Complete the 'timeConversion' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING s as parameter.
#


def timeConversion(s):
    # Write your code here
    meridiem = s[8:]
    time = s[:8].split(":")

    if meridiem == "AM" and time[0] == "12":
        time[0] = "00"
    elif meridiem == "PM" and time[0] != "12":
        time[0] = str(int(time[0]) + 12)
    else:
        return s[:8]

    return ":".join(time)


if __name__ == "__main__":

    s = "07:05:45PM"

    result = timeConversion(s)

    print(result)

    s = "12:05:45AM"

    result = timeConversion(s)

    print(result)
