import java.util.Scanner;
/**
 * Class for student.
 * @author tezasrivishnu.
 */
class Student{
    private String name;
    private String id;
    private double m1;
    private double m2;
    private double m3;
    public Student(final String name, final String id, 
                            final double m1, final double m2, final double m3){
        this.name = name;
        this.id = id;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }
    /**
     * checking CGPA.
     * @param      m1   double is the parameter.
     * @param      m2   double is the parameter.
     * @param      m3   double is the parameter.
     *
     * @return     { description_of_the_return_value }
     */
    public static double CGPA(final double m1, final double m2, final double m3) {
        //return Math.round(((m1+m2+m3)/3));
        return ((m1 + m2 + m3) / 3.0);
    }
    public String toString() {
        return ("< " + this.name + " " + this.id + " " + this.m1 + " "
                + this.m2 + " " + this.m3 + " >");
    }
}
/**
 * Class for student details.
 * giving the input.
 */
public class StudentDetails {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        String id = sc.next();
        double m1 = sc.nextInt();
        double m2 = sc.nextInt();
        double m3 = sc.nextInt();
        Student sd = new Student(name, id, m1, m2, m3);
        System.out.println(sd.toString());
        System.out.println("CGPA is " + sd.CGPA(m1, m2, m3));;
    }
}