package university;

public abstract class AdmnistrativeSection {
    private String name;
    private int cost;

    public AdmnistrativeSection(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public abstract int getQuantityOfStudents();
    public String getName(){
        return name;
    }
    public int getCost() {
        return cost;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCost(int cost) {
        if (cost < 0) {
            cost = 0;
        }
        this.cost = cost;
    }
}
