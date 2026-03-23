package MultiDimensional;

public class TwoDArray {
    public static void main(String[] args) {
        int [][] arr= new int[3][4];// ******************* 2D Array

        // Fill array with random values
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                // ************ to print tenth digit number use 10, hundred-digit numbers use 100
                arr[i][j]=(int)(Math.random()*10);
            }
        }

        // Print array
        for(int[]i:arr){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
