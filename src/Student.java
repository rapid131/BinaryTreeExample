/**
 * Student class that takes test1,test2,test3,name, student id and calculates percent score and assigns letter grade
 * updated version takes total_hours, cumulativeGPA, year_rank, and uses classGP to calculate newGPA based on 2 hours
 */
class Student implements Comparable<Object>{
    protected double test1, test2, test3;
    protected double pscore;
    protected String name;
    protected String studentid;
    protected String lettergrade;
    protected int total_hours;
    protected float cumulativeGPA;
    protected String year_rank;
    protected int classGP;
    protected float newGPA;
    //Constructor with variables and percent score calculations/letter grade assignment
    public Student(String id, String studentname, double t1, double t2, double t3, int hours, float GPA) {
        cumulativeGPA = GPA;
        test1 = t1;
        test2 = t2;
        test3 = t3;
        name = studentname;
        studentid = id;
        pscore = ((t1 + t2 + t3) / 3);
        total_hours = hours;
        if (pscore <= 59.999) {
            classGP = 0;
            lettergrade = "F";
        }
        if (pscore <= 69.999 && pscore >= 60) {
            classGP = 1;
            lettergrade = "D";
        }
        if (pscore <= 79.999 && pscore >= 70) {
            classGP = 2;
            lettergrade = "C";
        }
        if (pscore <= 89.999 && pscore >= 80) {
            classGP = 3;
            lettergrade = "B";
        }
        if (pscore <= 100 && pscore >= 90) {
            classGP = 4;
            lettergrade = "A";
        }
        if (total_hours <= 30){
            year_rank = "FR";
        }
        if (total_hours >= 31 && total_hours <=60){
            year_rank = "SO";
        }
        if (total_hours >= 61 && total_hours <=90){
            year_rank = "JR";
        }
        if (total_hours >= 91){
            year_rank = "SR";
        }
        newGPA = ((cumulativeGPA*total_hours)+(2*classGP))/(total_hours+2);

    } //end of constructor

    public String getId() {
        return studentid;
    }
    public void print() {
        System.out.printf("%-5s %-10s Test1: %-7.2f Test2: %-7.2f Test3: %-7.2f Average: %-7.2f Letter Grade: %-2s Total Hours: %-5d Cumulative GPA: %-5.2f Year Rank: %2s New GPA: %-10.2f", studentid, name, test1, test2, test3, pscore,lettergrade,total_hours,cumulativeGPA,year_rank,newGPA);
    } //end of print
    public String toString() {
        String s = String.format("%-5s %-10s Test1: %-7.2f Test2: %-7.2f Test3: %-7.2f Average: %-7.2f Letter Grade: %-2s Total Hours: %-5d Cumulative GPA: %-5.2f Year Rank: %2s New GPA: %-10.2f", studentid, name, test1, test2, test3, pscore,lettergrade,total_hours,cumulativeGPA,year_rank,newGPA);
        return s;
    } //end of toString
    //overrides compareTo statement for use in SortLarge
    public int compareTo(Object o) {
        if (pscore > ((Student) o).pscore)
            return 1;
        else if (pscore < ((Student) o).pscore)
            return -1;
        else
            return 0;
    } //end of compareTo
} //end of Student