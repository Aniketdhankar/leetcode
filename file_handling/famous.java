package file_handling;
import java.io.*;
import java.util.*;

public class famous {
    // NOTE: Class Name should be Main



    public static void main(String[] args) throws InterruptedException {
        List<String> inputByLine = new ArrayList<>();

        try {
            // 🔹 Change this line for input source:
            // For console input:
            InputStreamReader isr = new InputStreamReader(System.in);

            // For file input (uncomment this and comment the above line):
            // InputStreamReader isr = new InputStreamReader(new FileInputStream("input.txt"));

            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null && !line.trim().isEmpty()) {
                inputByLine.add(line.trim());
            }

            // 🔹 Parse first line -> m and n
            String[] first = inputByLine.get(0).split("\\s+");
            int m = Integer.parseInt(first[0]);
            int n = Integer.parseInt(first[1]);

            int[][] matrix = new int[m][n];

            // 🔹 Read the matrix lines
            for (int i = 0; i < m; i++) {
                String[] parts = inputByLine.get(i + 1).split("\\s+");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(parts[j]);
                }
            }

            // 🔹 Print matrix
            System.out.println("Matrix:");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            isr.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    
}
