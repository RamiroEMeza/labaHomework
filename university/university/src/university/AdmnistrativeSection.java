package university;

public abstract class AdmnistrativeSection {
    protected String name;
    protected int cost;
    public abstract int getQuantityOfStudents();
    public String getName(){
        return name;
    }
    public int getCost() {
        return cost;
    }
}
