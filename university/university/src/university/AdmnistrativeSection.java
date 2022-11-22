package university;

import java.util.Objects;

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


}
