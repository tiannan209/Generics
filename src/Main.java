import java.util.*;
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World, this is a Generics test.");

        Test<Integer> intObj = new Test<>(15);
        System.out.println(intObj.getObject());

        Test<String> strObj = new Test<>("Loser");
        System.out.println(strObj.getObject());
        strObj.genericDisplay(100);
        strObj.genericDisplay(1.0);

        Box<Integer> integerBox = new Box<>();
        integerBox.setT(100);
        integerBox.inspect(1.23);

        Integer[] array = {1,2,4,5,6,9};
        System.out.println(countGreaterThan(array, 5));

        // is-a relationship
        Object someObject = new Object();
        Integer someInteger = new Integer(10);
        someObject = someInteger;


        //type inference sample
        java.util.ArrayList<Box<Integer>> listOfIntegerBoxes =
                new java.util.ArrayList<>();
        Main.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes);
        addBox(Integer.valueOf(20), listOfIntegerBoxes);
        addBox(Integer.valueOf(30), listOfIntegerBoxes);
        outputBoxes(listOfIntegerBoxes);


        //Wildcard sample
        //Upper Bounded Integer List
        List<Integer> list1= Arrays.asList(4,5,6,7);

        //printing the sum of elements in list
        System.out.println("Total sum is:"+wildcardSum(list1));

        //Double list
        List<Double> list2=Arrays.asList(4.1,5.1,6.1);

        //printing the sum of elements in list
        System.out.println("Total sum is:"+wildcardSum(list2));
        //System.out.println("Total sum without wildcard:" + sum(list2));

        //test for position exchange
        String[] name  = {"tian", "liu", "tang", "zhou", "zhang"};
        System.out.println(Arrays.asList(swap(name, 0, 2)).toString());

    }

    public static <T extends Comparable<T>> int countGreaterThan(T[] array, T element){
        int count = 0;
        for (T t : array){
            if(t.compareTo(element) > 0){
                count++;
            }
        }
        return count;
    }

    public static <U> void addBox(U u, java.util.List<Box<U>> boxes){
        Box<U> box = new Box<>();
        box.setT(u);
        boxes.add(box);
    }

    public static <U> void outputBoxes(java.util.List<Box<U>> boxes){
        int counter = 0;
        for(Box<U> box : boxes){
            U boxObject = box.getT();
            System.out.println("Box #" + counter + " contains [" +
                    boxObject.toString() + "]");
            counter++;
        }
    }

    private static double wildcardSum(List<? extends Number> list)
    {
        double sum=0.0;
        for (Number i: list)
        {
            sum+=i.doubleValue();
        }

        return sum;
    }

    private static double sum(List<Number> list)
    {
        double sum=0.0;
        for (Number i: list)
        {
            sum+=i.doubleValue();
        }

        return sum;
    }

    /**
     * This generics method is to exchange the positions of two different elements in an array.
     * @param array
     * @param i
     * @param j
     * @param <T>
     * @return
     */
    public static <T> T[] swap(T[] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return array;
    }
}
