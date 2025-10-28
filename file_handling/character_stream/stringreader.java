package file_handling.character_stream;

import java.io.BufferedReader;
import java.io.StringReader;

public class stringreader {
     public static void main(String[] args) {
        String str = "5 5\n1,2,3,5,6\n4,5,6,7,8\n7,8,9,8,9\n1,1,1,1,1\n2,2,2,2,2";
        try{
            StringReader file = new StringReader(str);
            BufferedReader br = new BufferedReader(file);

            // Read first line for m and n
            String firstLine = br.readLine();
            if (firstLine == null) {
                System.out.println("File is empty!");
                return;
            }

            String[] dims = firstLine.trim().split("\\s+");
            int m = Integer.parseInt(dims[0]);
            int n = Integer.parseInt(dims[1]);

            int[][] matrix = new int[m][n];

            // Read the matrix rows
            for(int i=0;i<m;i++){
                String line = br.readLine();
                String[] numbers = line.trim().split(",");
                for(int j=0;j<n;j++){
                    matrix[i][j] = Integer.parseInt(numbers[j].trim());
                }
            }

            // Print the matrix
            System.out.println("\nMatrix:");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("Error reading string: " + e);
        }
    }
}
