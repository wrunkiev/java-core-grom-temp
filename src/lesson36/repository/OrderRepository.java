package lesson36.repository;

import lesson36.model.Order;
import java.io.*;
import java.util.ArrayList;

public class OrderRepository {
    private static String path = "C:/Soft/Files/OrderDb.txt";

    private void validateOrderDb()throws Exception{
        File file = new File(path);
        if(!file.exists())
            throw new Exception("Exception in method 'validateOrderDb'. Access denied to data base of order");

        if(!file.canRead())
            throw new Exception("Exception in method 'validateOrderDb'. Can't read from data base of order");

        if(!file.canWrite())
            throw new Exception("Exception in method 'validateOrderDb'. Can't write to data base of order");
    }

    public ArrayList<String> readOrdersFromDb()throws Exception{
        validateOrderDb();
        ArrayList<String> res = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null){
                res.add(line);
            }
        }catch (IOException e){
            System.err.println("Exception in method 'readOrdersFromDb'. Reading from file " + path + " failed");
        }
        return res;
    }

    public Order addOrder(Order order)throws Exception{
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))){
            if(readOrdersFromDb().size() == 0)
                bufferedWriter.append(order.toString());
            else{
                bufferedWriter.append("\n");
                bufferedWriter.append(order.toString());
            }
        }catch (IOException e){
            System.err.println("Exception in method 'addRoom'. Can't write to file " + path);
        }
        return order;
    }

    public void deleteOrder(int orderId)throws Exception{
        ArrayList<String> orders = readOrdersFromDb();

        orders.remove(orderId);

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))){
            int index = 1;
            for(String o : orders){
                if(orders.size() == index){
                    bufferedWriter.append(o);
                }else {
                    bufferedWriter.append(o);
                    bufferedWriter.append("\n");
                }
                index++;
            }
        }catch (IOException e){
            System.err.println("Exception in method 'deleteOrder'. Can't write to file " + path);
        }
    }
}
