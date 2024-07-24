

public class Main {
    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray(8);
        arr.push(1);
        arr.push(3);
        System.out.println(arr.toString());

        arr.insert(2, 1);
        arr.remove(2);

        System.out.println(arr.toString());

        arr.push(4);
        arr.push(5);
        arr.push(6);
        arr.push(7);

        arr.prepend(8);
        arr.pop();
        arr.pop();
        arr.pop();
        arr.pop();
        arr.pop();
        System.out.println(arr.toString());

    }
}



