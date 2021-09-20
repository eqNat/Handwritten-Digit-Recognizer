import java.io.*;  
import java.util.Scanner;  
public class Matrix 
{  
    public int rows;
    public int columns;
    public float matrix[][];

    public Matrix(String filename)
    {  
        try {
            Scanner sc = new Scanner(new File(filename));  
            sc.useDelimiter(",|\\n");

            rows = sc.nextInt();
            columns = sc.nextInt();

            matrix = new float[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = sc.nextFloat();
                }
            }
        sc.close();
        } catch(Exception e) {
            System.err.println(e);
        }
    }

    // zero matrix
    public Matrix(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;
        matrix = new float[rows][columns];
    }

    public Matrix dot(Matrix right)
    {
        Matrix result = new Matrix(this.rows, right.columns);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < right.columns; j++) {
                for (int k = 0; k < this.columns; k++) {
                    result.matrix[i][j] += this.matrix[i][k] * right.matrix[k][j];
                }
            }
        }
        return result;
    }

    @Override
    public String toString()
    {
        String str = new String("\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                str = str.concat(String.valueOf("\t" + matrix[i][j]));
            }
            str = str.concat("\n");
        }
        return str;
    }

    public static void main(String[] args)
    {
            Matrix matrix1 = new Matrix("./matrix1.csv");
            Matrix matrix2 = new Matrix("./matrix2.csv");

            Matrix product = matrix1.dot(matrix2);
            System.out.println(product);
    }
}