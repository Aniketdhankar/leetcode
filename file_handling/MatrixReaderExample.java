package file_handling;
import java.io.*;
import java.util.*;

public class MatrixReaderExample {
    public static void main(String[] args) {
        try {
            //if want to add file// 
           // FileInputStream fis=new FileInputStream("matrix.txt");
           //  InputStreamReader isr=new InputStreamReader(fis,"UTF-8");


            InputStreamReader isr = new InputStreamReader(System.in,"UTF-8");
            // 1️⃣ Create reader (you can change System.in to a FileReader for file input)
            BufferedReader br = new BufferedReader(isr);

            // 2️⃣ Read first line → contains m and n separated by space
            String firstLine = br.readLine();
            String[] dims = firstLine.split(" ");
            int m = Integer.parseInt(dims[0]);
            int n = Integer.parseInt(dims[1]);

            System.out.println("m = " + m + ", n = " + n);

            // 3️⃣ Create matrix
            int[][] matrix = new int[m][n];

            // 4️⃣ Read next m lines
            for (int i = 0; i < m; i++) {
                String line = br.readLine();          // read one line like "1,2,3"
                String[] numbers = line.split(",");   // split by comma
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(numbers[j].trim());  // convert to int
                }
            }

            // 5️⃣ Print matrix
            System.out.println("Matrix:");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

