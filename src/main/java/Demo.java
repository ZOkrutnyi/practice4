
public class Demo {

    public static void main(String[] args) {
        AbstractList<Integer> arrayList = new LinkedListImpl<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(5);
//        arrayList.clear();
//        System.out.println(arrayList.contains(3));
//        arrayList.set(2,41);
//        arrayList.remove( 1);
        for (Integer i: arrayList) {
            System.out.println(i);
        }
    }
}
