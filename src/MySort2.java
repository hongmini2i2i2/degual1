public class MySort2 {

    public static void main(String[] args) {
        int[] data = {113, 336, 74, 71, 86, 176, 313, 80, 225, 342,
                170, 292, 275, 266, 79, 16, 109, 175, 245, 156,
                50, 61, 277, 167, 81, 24, 76, 186, 78, 101,
                301, 62, 152, 219, 294};

        System.out.println("\n< Initial Data>");
        showData(data);

        MySort2 ms = new MySort2();
        int[] dataSorted = new int[data.length];

        System.out.println("\n< Quick Sort >");
        dataSorted = data.clone();
        ms.quickSort(dataSorted, 0, dataSorted.length - 1);
        showData(dataSorted);

        System.out.println("\n< Merge Sort >");
        dataSorted = data.clone();
        ms.mergeSort(dataSorted, 0, dataSorted.length - 1);
        showData(dataSorted);
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

    private int[] swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
        return data;
    }
    //////////////Quick Sort//////////////
    public int[] quickSort(int[] data) {
        return quickSort(data, 0, data.length - 1);
    }

    private int[] quickSort(int[] data, int p, int r) { // overloading ... 매개변수만 다른거
        if (p < r) {
            int q = partition(data, p, r);
            quickSort(data, p, q-1);
            quickSort(data, q+1, r);
        }
        return data;
    }

    private int partition(int[] data, int p, int r) {
        /**int pivot = r;

        int left = p;
        int right = r;

        while (left < right) {
            while (data[left] < data[pivot])
                left++;
            while (right > left && data[right] >= data[pivot])
                right--;

            if (left < right)
                swap(data, left, right);
        }
        swap(data, pivot, left);

        return left; // == right*/
        int x = data[r];
        int k = p - 1;

        for(int i = p; i<r; i++) {
            if(data[i] < x) {
                swap(data, ++k, i);
            }
        }
        swap(data, k+1, r);
        return k+1;
    }
//////////////Merge Sort//////////////
    public int[] mergeSort(int[] data) {
        return mergeSort(data, 0, data.length - 1);
    }

    private int[] mergeSort(int[] data, int p, int r) {

        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(data, p, q);
            mergeSort(data, q + 1, r);
            merge(data, p, q, r);
        }
        return data;
    }

    private int[] merge(int[] data, int p, int q, int r) {
        int[] temp = new int[data.length];

        int i = p;
        int j = q + 1;
        int k = p;

        while (i <= q && j <= r) {
            if (data[i] < data[j])
                temp[k++] = data[i++];
            else
                temp[k++] = data[j++];
        }

        while (i <= q) {
            temp[k++] = data[i++];
        }

        while (j <= r) {
            temp[k++] = data[j++];
        }

        for (int l = p; l <= r; l++)
            data[l] = temp[l];

        return data;
    }
}
