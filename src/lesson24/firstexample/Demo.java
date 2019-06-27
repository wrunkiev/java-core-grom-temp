package lesson24.firstexample;

import lesson24.firstexample.AbstractOrder;

public class Demo <T>{


    /*private printUser(User user){
        //print
    }

    private printSolution(Solution solution){
        //print
    }

    private printChannel(Channel channel){
        //print
    }*/
    private static void calculatePrice(AbstractOrder abstractOrder){
        System.out.println(abstractOrder.getPrice());
    }

    public void print(T t){
        System.out.println(t);
    }




}
