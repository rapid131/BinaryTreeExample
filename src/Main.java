import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Thomas Hutton
 * Variables:
 * outpt: PrintWriter variable
 * textoutput: text file
 * student_class: BinaryTreeManager binary tree for students
 * id: temp for id
 * name: temp for name
 * test1: temp for first test score
 * test2: temp for second test score
 * test3: temp for third test score
 * cumulativeGPA: temp for cumulative gpa
 * student1: temp for new student objects
 * Description: Program creates a binary tree and student objects and places the objects in the binary tree
 * based on their average percent test score. The binary tree can traverse and print the binary tree inorder,
 * preorder, and postorder
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter outpt;
        File textoutput = new File("BinaryTreeOutput.txt");
        outpt = new PrintWriter(textoutput);
        BinaryTreeManager<Student> student_class = new BinaryTreeManager<Student>();
        try {
            Scanner input = new Scanner(new File("Studentinput.txt"));
            while (input.hasNext()) {
                String id = input.next();
                String name = input.next();
                int test1 = input.nextInt();
                int test2 = input.nextInt();
                int test3 = input.nextInt();
                int total_hours = input.nextInt();
                float cumulativeGPA = input.nextFloat();
                //adding the students to the array while creating the objects
                Student student1 = new Student(id, name, test1, test2, test3, total_hours,cumulativeGPA);
                student_class.insertnode(student1);
            } //end of while, one line below this is end of try
        } catch (NoSuchElementException elementException) {
            System.err.println("File not formatted correctly");
            System.exit(1);
        } //end of catch
        //print the binary tree inorder
        student_class.inorder(outpt);
        System.out.println();
        outpt.println();
        //print the binary tree preorder
        student_class.preorder(outpt);
        System.out.println();
        outpt.println();
        //print the binary tree postorder
        student_class.postorder(outpt);
        outpt.close();
    }
}
