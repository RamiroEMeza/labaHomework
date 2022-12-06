package university.members;

public class Teacher extends Member {
    private int rating;

    public Teacher(String name, int idNumber, int rating) {
        super(name, idNumber);
        this.setRating(rating);
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating < 0) {
            rating *= (-1);
        }
        this.rating = rating;
    }
}
