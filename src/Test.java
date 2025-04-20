public class Test {

    public static void main(String[] args) {
        MyArrayList2<MyArrayList1> list = new MyArrayList2<>();

        MyArrayList1 a = new MyArrayList1(); //리스트를 원소로 넣기 가능
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        MyArrayList1 b = new MyArrayList1();
        a.add(11);
        a.add(21);
        a.add(31);

        list.add(a);  //리스트를 원소로 넣기 가능
        list.add(b);

        list.showList();

        list.get(0).set(2, 30); //시험
        list.showList();
    }

}
