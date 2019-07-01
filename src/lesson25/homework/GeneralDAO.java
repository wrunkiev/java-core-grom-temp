package lesson25.homework;

import java.lang.reflect.Array;

public class GeneralDAO<T> {

    @SuppressWarnings("unchecked")
    private T[] array = (T[])new Object[10];

    public T save(T t)throws Exception{

        validate(t);

        int index = 0;
        for(T el : array){
            if(el == null){
                array[index] = t;
                return array[index];
            }
            index++;
        }
        throw new Exception("Array has not free place");
    }

    private void validate(T t) throws Exception{
        if(t == null)
            throw new Exception("Can't null");

        int index = 0;
        for(T el : array){
            if(el.equals(t)){
                throw new Exception("Array have already that element");
            }
            index++;
        }
    }



    public T[] getAll(){
        return array;
    }
}
