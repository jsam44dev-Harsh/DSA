package MultiDimensional;

public class JaggedArray {
    public static void main(String[] args) {
        int[][] arr = new int[3][]; // **********jagged Array
        arr[0] = new int[3];
        arr[1] = new int[4];
        arr[2] = new int[2];

        // Fill array with random values
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int)(Math.random() * 10);
            }
        }

        // Print array
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
