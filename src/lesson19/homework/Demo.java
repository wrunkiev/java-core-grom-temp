package lesson19.homework;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        try {
            File file1 = new File(1, "file1", "txt", 100);
            File file2 = new File(2, "file2", "jpg", 120);
            File file3 = new File(3, "file3", "doc", 250);
            File file4 = new File(4, "file4", "txt", 170);
            File file5 = new File(5, "file5", "doc", 140);
            File file = new File(6, "file1", "doc", 140);
            File[] files1 = new File[]{file1, file2, file3, file4, file5};
            String[] formats1 = new String[]{"txt", "jpg", "doc"};
            Storage storage1 = new Storage(1, files1, formats1, "Ukraine", 1500);

            Controller controller = new Controller();

            System.out.println(Arrays.toString(storage1.getFiles()));
            controller.put(storage1, file);
            System.out.println(Arrays.toString(storage1.getFiles()));

            /*controller.delete(storage1, file);
            System.out.println(Arrays.toString(storage1.getFiles()));*/




            /*File file6 = new File(6, "file6", "txt", 100);
            File file7 = new File(7, "file7", "jpg", 120);
            File file8 = new File(8, "file8", "doc", 250);
            File file9 = new File(9, "file9", "txt", 170);
            File file10 = new File(10, "file10", "doc", 140);
            File[] files2 = new File[]{file6, file7, null, null, null, file8, file9, null};
            String[] formats2 = new String[]{"doc", "txt", "jpg"};
            Storage storage2 = new Storage(2, files2, formats2, "Ukraine", 3700);

            System.out.println(Arrays.toString(storage1.getFiles()));
            System.out.println(Arrays.toString(storage2.getFiles()));

            controller.transferAll(storage1, storage2);

            System.out.println(Arrays.toString(storage1.getFiles()));
            System.out.println(Arrays.toString(storage2.getFiles()));*/




        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
