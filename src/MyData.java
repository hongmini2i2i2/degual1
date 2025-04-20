public class MyData {

    int num;
    String name;

    public MyData(int n, String s) {
        this.num = n;
        this.name = s;
    }

    public String toString() {
        return num + " " + name;
    }

    @Override
    public boolean equals (Object that) {
        return (this.num == ((MyData)that).num);
    }

}
