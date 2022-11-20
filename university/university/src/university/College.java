package university;

import java.util.ArrayList;

public class College extends AdmnistrativeSection{
    private ArrayList<Speciality> specialities;
    private int id;

    public College(String name, int cost, int id) {
        this.name = name;
        this.id = id;
        this.cost = cost;
        this.specialities = new ArrayList<Speciality>();
    }

    public boolean haveSpecialityById(int specialityId){
        for (Speciality speciality:
             this.specialities) {
            if (speciality.getId() == specialityId) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getQuantityOfStudents() {
        return 0;
    }

    public int calculateCost(int specialityId) {
        int result = 0;
        for (Speciality speciality : specialities) {
            if (speciality.getId() == specialityId) {
                result = speciality.calculateCost();
            }
        }
        return result + this.cost;
    }


    public ArrayList<String> getSpecialities() {
        ArrayList<String> response = new ArrayList<String>();
        for (Speciality speciality : specialities) {
            response.add(speciality.getName() + " (" + speciality.getId() + ")\n [Subjects: "
                        + speciality.getQuantitySubjects() +"]\n At "
                        + this.getName());
        }
        return response;
    }


    public void addSpeciality(Speciality speciality){
        if(!this.specialities.contains(speciality)){
            this.specialities.add(speciality);
        }
    }

    public int getId() {
        return id;
    }

    public String getSpecialityById(int specialityId){
        for (Speciality speciality: this.specialities) {
            if (speciality.getId() == specialityId){
                return speciality.getName();
            }
        }
        return null;
    }

    public void addSubjectToSpeciality(int specialityId, Subject subject) {
        for (Speciality speciality : this.specialities) {
            if (speciality.getId() == specialityId) {
                speciality.addSubject(subject);
            }
        }
    }
}
