import java.util.Arrays;

public class ArrayProcessing {

    public static class Array1DProcessing {
        private int[] array;

        public Array1DProcessing(int[] array) {
            this.array = array;
        }

        public String checkArrayOrder() {
            boolean ascending = true;
            boolean descending = true;

            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    ascending = false;
                }
                if (array[i] < array[i + 1]) {
                    descending = false;
                }
            }

            if (ascending) {
                return "Масив відсортований за зростанням";
            } else if (descending) {
                return "Масив відсортований за спаданням";
            } else {
                return "Масив не відсортований";
            }
        }

        public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
            int[] result = new int[arr1.length + arr2.length];
            int i = 0, j = 0, k = 0;

            while (i < arr1.length && j < arr2.length) {
                if (arr1[i] <= arr2[j]) {
                    result[k++] = arr1[i++];
                } else {
                    result[k++] = arr2[j++];
                }
            }

            while (i < arr1.length) {
                result[k++] = arr1[i++];
            }

            while (j < arr2.length) {
                result[k++] = arr2[j++];
            }

            return result;
        }
    }

    public static class Array2DProcessing {
        private int[][] array;

        public Array2DProcessing(int[][] array) {
            this.array = array;
        }

        public void printArray() {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
        }

        public void transposeArray() {
            int rows = array.length;
            int cols = array[0].length;
            int[][] transposed = new int[cols][rows];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    transposed[j][i] = array[i][j];
                }
            }

            System.out.println("Транспонований масив:");
            for (int i = 0; i < cols; i++) {
                for (int j = 0; j < rows; j++) {
                    System.out.print(transposed[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {5, 4, 3, 2, 1};
        int[] array3 = {1, 3, 2, 4, 5};
        Array1DProcessing processor1 = new Array1DProcessing(array1);
        Array1DProcessing processor2 = new Array1DProcessing(array2);
        Array1DProcessing processor3 = new Array1DProcessing(array3);

        System.out.println("Array 1: " + processor1.checkArrayOrder());
        System.out.println("Array 2: " + processor2.checkArrayOrder());
        System.out.println("Array 3: " + processor3.checkArrayOrder());

        int[] array4 = {1, 3, 5, 7};
        int[] array5 = {2, 4, 6, 8};
        int[] mergedArray = Array1DProcessing.mergeSortedArrays(array4, array5);

        System.out.println("Об'єднаний відсортований масив:");
        for (int i : mergedArray) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[][] array2D = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Array2DProcessing processor2D = new Array2DProcessing(array2D);
        System.out.println("Початковий двовимірний масив:");
        processor2D.printArray();

        processor2D.transposeArray();
    }
}
