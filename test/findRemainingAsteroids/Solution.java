package findRemainingAsteroids;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'findRemainingAsteroids' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY size
   *  2. INTEGER_ARRAY direction
   */

  public static List<Integer> findRemainingAsteroids(List<Integer> size, List<Integer> direction) {
    List<Integer> newSize = new ArrayList<Integer>();
    List<Integer> newDir = new ArrayList<Integer>();
    int length = size.size();
    if (length == 1) {
      return size;
    }
    for (int i = 0; i < length; i++) {
      if (newSize.size() == 0) {
        newSize.add(size.get(i));
        newDir.add(direction.get(i));
      } else if (newDir.get(newDir.size() - 1) == 1 && direction.get(i) == 0) {
        while (newDir.get(newDir.size() - 1) == 1 && direction.get(i) == 0) {
          if (newSize.get(newSize.size() - 1) > size.get(i)) {
            // do nothing
            break;
          } else if (newSize.get(newSize.size() - 1) < size.get(i)) {
            newSize.remove(newSize.size() - 1);
            newDir.remove(newDir.size() - 1);
            if (newDir.size() == 0) {
              newSize.add(size.get(i));
              newDir.add(direction.get(i));
              break;
            }
          } else {
            newSize.remove(newSize.size() - 1);
            newDir.remove(newDir.size() - 1);
            if (newDir.size() == 0) {
              break;
            }
          }
        }
      } else {
        newSize.add(size.get(i));
        newDir.add(direction.get(i));
      }
    }
    return newSize;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter("findRemainingAsteroids/output.txt"));

    int sizeCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> size =
        IntStream.range(0, sizeCount)
            .mapToObj(
                i -> {
                  try {
                    return bufferedReader.readLine().replaceAll("\\s+$", "");
                  } catch (IOException ex) {
                    throw new RuntimeException(ex);
                  }
                })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

    int directionCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> direction =
        IntStream.range(0, directionCount)
            .mapToObj(
                i -> {
                  try {
                    return bufferedReader.readLine().replaceAll("\\s+$", "");
                  } catch (IOException ex) {
                    throw new RuntimeException(ex);
                  }
                })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

    List<Integer> result = Result.findRemainingAsteroids(size, direction);

    bufferedWriter.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
