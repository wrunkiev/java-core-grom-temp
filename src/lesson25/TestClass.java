package lesson25;

public class TestClass <T, K, V> {
    public T doSomething1(T t){
        System.out.println("1");
        return t;
    }

    public K doSomething2(K k){
        System.out.println("2");
        return k;
    }

    public V doSomething3(V v){
        System.out.println("3");
        return v;
    }


}
