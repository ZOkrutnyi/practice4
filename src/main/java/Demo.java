import java.util.*;

public class Demo {

    public static void main(String[] args) {
        sort();
    }

    private static void sort() {
        Demo d1 = new Demo();
        Demo d2 = new Demo();
        Demo d3 = new Demo();
        Demo d4 = new Demo();
        Demo d5 = d1;
        List<Demo> list = new ArrayList<>();
        list.add(d1);
        list.add(d2);
        list.add(d3);
        list.add(d4);
        list.add(d5);
        Queue<Demo> q = new ArrayDeque<>(list);
        Stack<Demo> stack = new Stack<>();
        stack.addAll(list);
        System.out.println("-------------Original--------------");
        list.forEach(System.out::println);
        System.out.println("-------------Queue--------------");
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println("-------------Stack--------------");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("-------------Set--------------");
        Set<Demo> s = new HashSet<>(list);
        s.forEach(System.out::println);
        System.out.println("--------------Comparing-------------");
        list.stream().sorted(Comparator.comparing(Objects::toString)).forEach(System.out::println);
        System.out.println("---------------------------");
        list.stream().sorted(Comparator.comparingInt(Objects::hashCode)).forEach(System.out::println);
    }
}
