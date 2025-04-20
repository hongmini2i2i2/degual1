public class MogongSort {


    public static void main(String[] args) {
        int[] data = {113, 336, 74, 71, 86, 176, 313, 80, 225, 342,
                170, 292, 275, 266, 79, 16, 109, 175, 245, 156,
                50, 61, 277, 167, 81, 24, 76, 186, 78, 101,
                301, 62, 152, 219, 294};

        // Selection Sort
        int[] toBeSorted = data.clone();
        System.out.println("\n< Selection Sort >");
        selectionSort2Iterative(toBeSorted);
        showData(toBeSorted);

        // Insertion Sort
        toBeSorted = data.clone();
        System.out.println("\n< Insertion Sort >");
        insertionSortRecursive(toBeSorted, toBeSorted.length);
        showData(toBeSorted);

        // Bubble Sort
        toBeSorted = data.clone();
        System.out.println("\n< Bubble Sort >");
        bubbleSortRecursive(toBeSorted, toBeSorted.length);
        showData(toBeSorted);
    }

    public static int[] selectionSort2Iterative(int[] data) {
        int n = data.length;
        for (int end = n - 1; end > 0; end--) {
            int maxIndex = end;
            for (int i = 0; i < end; i++) {
                if (data[i] > data[maxIndex]) {
                    maxIndex = i;
                }
            }
            swap(data, maxIndex, end);
        }
        return data;
    }

    public static int[] insertionSortRecursive(int[] data, int n) {
        if(n<=1) {
            return data;
        }

        insertionSortRecursive(data, n-1);

        int value = data[n-1];
        int j = n-2;

        while(j >= 0 && data[j] > value) {
            data[j+1] = data[j];
            j--;
        }
        data[j+1] = value;

        return data;
    }

    public static int[] bubbleSortRecursive(int[] data, int n) {
        if (n == 1) return data;

        for (int i = 0; i < n - 1; i++) {
            if (data[i] > data[i + 1]) {
                swap(data, i, i + 1);
            }
        }
        // 가장 큰 값은 맨 뒤에 정렬됐으므로 n-1만 다시 정렬
        return bubbleSortRecursive(data, n - 1);
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private static void showData(int[] data) {
        int nData = data.length;
        int nPrinted = 0;
        while (nPrinted < nData) {
            for (int i = 0; (nPrinted < nData) && (i < 10); i++) {
                System.out.printf("%6d ", data[nPrinted++]);
            }
            System.out.println();
        }
    }

}
