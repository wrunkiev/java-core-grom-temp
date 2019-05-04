package lesson8.homeworkStudents;

public class Demo {
        Student createHighestParent(){
            Student student = new Student("Alex", "Begemot", 3, new Course[]{});
            return student;
        }

        SpecialStudent createLowestChild(){
                SpecialStudent specialStudent = new SpecialStudent("Alex", "Ponomarenko", 3, new Course[]{}, 1234,"wer@rt.ua");
                return specialStudent;
        }
}