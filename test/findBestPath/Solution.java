package findBestPath;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'findBestPath' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. INTEGER startRow
     *  4. INTEGER startColumn
     *  5. INTEGER endRow
     *  6. INTEGER endColumn
     *  7. INTEGER_ARRAY obstacleRow
     *  8. INTEGER_ARRAY obstacleColumn
     */

    public static int findBestPath(int n, int m, int startRow, int startColumn, int endRow, int endColumn, List<Integer> obstacleRow, List<Integer> obstacleColumn) {
        
        int result = n;
        int distance;
        
        int cRow = startRow;
        int cColumn = startColumn;
        
        // calculate distance to a obstacle
        distance = disToOb(cRow, cColumn, obstacleRow, obstacleColumn);
        if(distance<result) result = distance;
        
        distance = disToOb(endRow, endColumn, obstacleRow, obstacleColumn);
        if(distance<result) result = distance;
        
        
        
        
        return result;

    }
    
    //helper for calculate distance to a obstacle
    public static int disToOb(int cRow, int cColumn, List<Integer> obstacleRow, List<Integer> obstacleColumn){
        int distance = 0;
        int min_distance = -1;
        int numOfObs = obstacleColumn.size();
        for(int i = 0; i < numOfObs; i++){
            distance = 0;
            if(cRow > obstacleRow.get(i)){
                distance+= cRow-obstacleRow.get(i);
            } else {
                distance+= obstacleRow.get(i)-cRow;
            }
            if(cColumn > obstacleColumn.get(i)){
                distance+= cColumn-obstacleColumn.get(i);
            } else {
                distance+= obstacleColumn.get(i)-cColumn;
            }
            if(min_distance == -1){
                min_distance = distance;
            } else if (min_distance > distance){
                min_distance = distance;
            }
        }
        
        return min_distance;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        int startRow = Integer.parseInt(bufferedReader.readLine().trim());

        int startColumn = Integer.parseInt(bufferedReader.readLine().trim());

        int endRow = Integer.parseInt(bufferedReader.readLine().trim());

        int endColumn = Integer.parseInt(bufferedReader.readLine().trim());

        int obstacleRowCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> obstacleRow = IntStream.range(0, obstacleRowCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int obstacleColumnCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> obstacleColumn = IntStream.range(0, obstacleColumnCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.findBestPath(n, m, startRow, startColumn, endRow, endColumn, obstacleRow, obstacleColumn);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
