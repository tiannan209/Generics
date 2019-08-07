public class Test<T> {
    T object;
    Test(T object){
        this.object = object;
    }

    public T getObject(){
        return this.object;
    }

    public <T> void genericDisplay(T element){
        System.out.println(element.getClass().getName() + "=" + element);
    }
}
