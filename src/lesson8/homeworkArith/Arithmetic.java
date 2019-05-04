package lesson8.homeworkArith;

public class Arithmetic {
    boolean check(int [] array){
        if(((long)max(array) + (long)min(array)) > 100)
            return true;
        return false;
    }

    int max(int [] array){
        int max = array[0];
        for (int i = 0; i < array.length; i++){
            if(max < array[i])
                max = array[i];
        }
        return max;
    }

    int min(int [] array){
        int min = array[0];
        for (int i = 0; i < array.length; i++){
            if(min > array[i])
                min = array[i];
        }
        return min;
    }
}
