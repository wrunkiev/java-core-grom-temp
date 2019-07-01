package lesson25.homework;

public class Demo {
    public static void main(String[] args){
        GeneralDAO<String> generalDAO = new GeneralDAO<>();
        try{
            generalDAO.save(null);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
