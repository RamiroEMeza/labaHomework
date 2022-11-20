package university.members;

public abstract class Member {
    protected String name;
    protected int idNumber;

    public String getName() {
        return name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

}
