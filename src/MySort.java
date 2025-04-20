import java.util.Arrays;

public class MySort {

    public static void main(String[] args) {
        int[] data = {113, 336, 74, 71, 86, 176, 313, 80, 225, 342,
                170, 292, 275, 266, 79, 16, 109, 175, 245, 156,
                50, 61, 277, 167, 81, 24, 76, 186, 78, 101,
                301, 62, 152, 219, 294};

        // Selection Sort
        int[] toBeSorted = data.clone();
        System.out.println("\n< Selection Sort >");
        selectionSort(toBeSorted, toBeSorted.length);
        showData(toBeSorted);

        // Insertion Sort
        toBeSorted = data.clone();
        System.out.println("\n< Insertion Sort >");
        insertionSort(toBeSorted, toBeSorted.length);
        showData(toBeSorted);

        // Bubble Sort
        toBeSorted = data.clone();
        System.out.println("\n< Bubble Sort >");
        bubbleSort(toBeSorted, toBeSorted.length);
        showData(toBeSorted);
    }

    public static int[] selectionSort(int[] data, int n) {
        return selectionSort2(data, n - 1);
    }

    public static int[] selectionSort2(int[] data, int n) { //제일 끝에서부터 앞에것들 비교하면서 크면 maxindex 바꾸고 맨뒤에꺼랑 스왑 반복
        if (n == 0) {
            return data;
        } else {
            int maxIndex = n;
            for (int i = 0; i <= n - 1; i++) {
                if (data[i] > data[maxIndex]) {
                    maxIndex = i;
                }
            }
            swap(data, maxIndex, n);
            return selectionSort2(data, n - 1);
        }
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

    public static int[] insertionSort(int[] data, int n) { //삽입할 값 [1]부터 왼쪽 값들 보면서 삽입할 곳 찾기
        for (int i = 1; i < n; i++) {
            int value = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > value) {
                data[j + 1] = data[j]; // 오른쪽 값만 왼쪽값으로 바꾸기
                j--;
            }
            data[j + 1] = value; // 삽입
        }
        return data;
    }

    public static int[] bubbleSort(int[] data, int n) { //뽀글뽀글
        if (n == 0) {
            return data;
        } else {
            for (int i = n - 1; i >= 0; i--) { // i > 0이어도 됨
                for (int j = 0; j <= i - 1; j++) {
                    if (data[j] > data[j + 1]) {
                        swap(data, j, j + 1);
                    }
                }
            }
            return data;
        }
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