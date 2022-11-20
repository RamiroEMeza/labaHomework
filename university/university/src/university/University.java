package university;

import university.members.Teacher;

import java.util.ArrayList;

public class University extends  AdmnistrativeSection{
    private ArrayList<College> colleges;
    private ArrayList<Teacher> teachers;

    public University(String name, int cost) {
        this.name = name;
        this.cost = cost;
        this.colleges = new ArrayList<College>();
        this.teachers = new ArrayList<Teacher>();
    }

    public int calculateCost(int specialityId){
        int result = 0;
        for (College college: this.colleges) {
            if(college.haveSpecialityById(specialityId)){
                result = college.calculateCost(specialityId);
            }
        }
        return result + this.cost;
    }

    public void addTeacher(Teacher teacher){
        if (!this.teachers.contains(teacher)) {
            this.teachers.add(teacher);
        }
    }

    public void addSubjectToSpeciality(int specialityId, Subject subject) {
        for (College college: this.colleges) {
            if(college.haveSpecialityById(specialityId)){
                college.addSubjectToSpeciality(specialityId, subject);
            }
        }
    }

    public void addCollege(College college){
        if (!this.colleges.contains(college)){
            this.colleges.add(college);
        }
    }

    public void addSpeciality(int collegeId, Speciality speciality) {
        for (College college: this.colleges) {
            if (college.getId() == collegeId){
                college.addSpeciality(speciality);
            }
        }
    }

    public Teacher getTeacher(int index){
        if (index <= this.teachers.size()){
            return this.teachers.get(index-1);
        }
        return null;
    }

    public int getTeachersQuantity(){
        return this.teachers.size();
    }

    @Override
    public int getQuantityOfStudents() {
        int result = 0;
        for (College college: this.colleges) {
            result += college.getQuantityOfStudents();
        }
        return result;
    }

    public ArrayList<String> getColleges(){
        ArrayList<String> response = new ArrayList<String>();
        for (College c : this.colleges) {
            response.add(c.getName());
        }
        return response;
    }

    public ArrayList<String> getSpecialities() {
        ArrayList<String> response = new ArrayList<String>();
        for (College c : this.colleges) {
            response.addAll(c.getSpecialities());
        }
        return response;
    }

    public String getSpecialityById(int specialityId){
        for (College college : this.colleges) {
            if (college.haveSpecialityById(specialityId)){
               return college.getSpecialityById(specialityId);
            }
        }
        return null;
    }
}
