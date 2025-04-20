
public class Search {

    public static int seqSearch(int[] d, int key) {
        /**	for(int i = 0; i<d.length; i++) {
         if(d[i] == key) {
         return i;
         }
         }

         return -1;
         } */
        int index = 0;

        while(index < d.length) {
            if(d[index] == key) {
                return index;
            } else {
                index++;
            }
        }
        return -1;
    }

    public static int seqSortedS(int[] d, int key) {
        int index = 0;

        while(index < d.length) {

            if(d[index] == key) {
                return index;
            } else {
                index++;
            }

        }
        return -1;
    }

    public static int bSort(int[] d, int key, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        System.out.println("mid: " + mid);
        System.out.println("d[mid]: " + d[mid]);
        if(key == d[mid]) {
            return mid;
        } else if (key < d[mid]) {
            return bSort(d, key, start, mid - 1);
        } else {
            return bSort(d, key, mid + 1, end);
        }
    }

    public int seqSRec(int[] d, int n, int key) {

        if (n == 0) {
            return -1;
        } else if(d[n - 1] == key) {
            return n-1;
        } else {
            return seqSRec(d, n - 1, key);
        }
    }

    public static void main(String[] args) {
        int[] data = {10, 45, 30, 20 ,25, 50, 55, 60};
        int[] sData =  {5, 10, 15 ,20 ,25};
        int[] bData = {1, 2, 3, 4, 5, 6, 7, 8 ,9 ,10, 11};

        System.out.println("\n" + seqSearch(data, 25));
        System.out.println(seqSortedS(sData, 25));
        System.out.println(bSort(bData , 3, 0, bData.length - 1));

    }

}
