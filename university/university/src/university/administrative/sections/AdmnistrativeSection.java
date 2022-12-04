package university.administrative.sections;

public abstract class AdmnistrativeSection {
    private String name;
    private int cost;

    public AdmnistrativeSection(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public abstract int getQuantityOfStudents();

    public final String getName() {
        return name;
    }

    public final int getCost() {
        return cost;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final void setCost(int cost) {
        if (cost < 0) {
            cost = 0;
        }
        this.cost = cost;
    }

}
