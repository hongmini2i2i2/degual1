import java.util.Arrays;

public class MyArrayList0 implements MyList {

    int [] array;
    int capacity;
    int size;

    public MyArrayList0(int n) {
        capacity = n;
        array = new int[capacity];
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexOf(Object value) {
        for (int i =0; i<size; i++) {
            if (array[i] == (int)value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void add(Object value) {
        if(!isFull()){
            array[size++] = (int)value;
        }
    }

    private boolean isFull() {
        return (size == capacity);
    }

    @Override
    public void add(int index, Object value) {
        if(checkIndexRange(index)) {
            if(!isFull()) {
                for (int i = size - 1; i >= index; i--) {
                    array[i + 1] = array[i];
                }
                //System.arrayCopy()
                array[index] = (int)value;
                size++;
            }
        }
        else if(index == size){
            add(value);
        }
    }

    private boolean checkIndexRange(int index) {
        if(index>=0 && index < size) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        Arrays.fill(array,0);
        size = 0;
    }

    @Override
    public boolean contains(Object value) {
//        for(int i=0; i<size; i++) {
//            if(array[i] == (int)value) {
//                return true;
//            }
//        }
//        return false;

        return indexOf(value)!=-1;
    }

    @Override
    public boolean remove(Object value) {
        int index = indexOf(value);
        if(checkIndexRange(index)) {
            for(int i = index; i < size; i++) {
                array[i - 1] = array[i];
            }
            size--;
            return true;
        } else {
            return false;
        }
        //return (boolean) remove(index);
    }

    @Override
    public Object remove(int index) {
//        if(checkIndexRange(index)) {
//            for(int i = index - 1; i < size; i++) {
//                array[i] = array[i+1];
//            }
//            size--;
//            return true;
//        } else {
//            return false;
//        }
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Object get(int index) {
        if(checkIndexRange(index)) {
            return array[index];
        }
        return null;
    }

    @Override
    public void set(int index, Object value) {
        if(checkIndexRange(index)) {
            array[index] = (int)value;
        }
    }

    public String toString() {
        String res = "";
        for(int i = 0; i < size; i++) {
            res = res + array[i] + " ";
        }
        return res;
    }

    public void showList() {
        System.out.println("Current List Status");
        System.out.println(toString());
    }

    public static void main(String[] args){

        int [] data = {113,  336,  74,  71,  86,  176,  313,  80,  225,  342,
                170,  292,  275,  266 , 79,  16,  109,  175 , 245,  156,
                50,  61,  277,  167,  81,  24,  76,  186,  78,  101,
                301,  62,  152,  219,  294};

        MyArrayList0 list = new MyArrayList0(20);

        for (int i=0;i<10; i++)
            list.add(data[i]);  // cf :  list[i]=data[i]
        list.showList();

        list.set(5, 999);     // list[5]=999
        int x =(int) list.get(5);  // cf : x = list[5]
        System.out.println("\nx = "+x);

        list.remove((Integer)336);
        list.showList();

        list.add(3, 111);
        list.showList();
        list.add(list.size(), 222);
        list.showList();

        list.clear();
        list.showList();

    }

}
