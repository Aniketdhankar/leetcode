package file_handling.character_stream;
import java.io.BufferedReader;
import java.io.FileReader;

public class filereader_bufferreader {
    public static void main(String[] args) {
        String fileName = "aniket.txt"; // file must exist in the project directory
        try{
            FileReader file=new FileReader(fileName);
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
                String line=br.readLine();
                String[] numbers=line.trim().split(",");
                for(int j=0;j<n;j++){
                    matrix[i][j] =Integer.parseInt(numbers[j].trim());
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
            System.out.println("Error reading file: " + e);
        }
    }
    
}
