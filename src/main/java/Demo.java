public class Demo {

    public static void main(String[] args) {
        AbstractList<Integer> arrayList = new CircledList<>(4);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        for (Integer i: arrayList) {
            System.out.println(i);
        }
    }
}
