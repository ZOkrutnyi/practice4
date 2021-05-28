
public class Demo {

    public static void main(String[] args) {
        ArrayListImpl<Integer> arrayList = new ArrayListImpl<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(5);
//        System.out.println(arrayList.contains(3));
//        arrayList.set(2,41);
        arrayList.remove( 1);
        for (Integer i: arrayList) {
            System.out.println(i);
        }
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.size());
    }
}
