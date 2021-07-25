package A1.A2.A3;

import A1.A2.Student;

import java.util.Date;

public class AAA implements Student {

    Date firstDate;
    Date birthday;
    String university;
    String surname;
    String name;
    String fatherName;

    public void setFirstDate(Date d) {

        firstDate = d;
    }

    public Date getFirstDate() {

        return firstDate;
    }

    public void setUniversity(String u) {

        university = u;
    }

    public String getUniversity() {

        return university;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setFathername(String fatherName) {

        this.fatherName = fatherName;
    }

    public void setBirthday(int yyyy, int mm, int dd) {

        birthday = new Date (yyyy, mm, dd);
    }

    public String getSurname() {

        return this.surname;
    }

    public String getName() {

        return this.name;
    }

    public String getFathername() {

        return this.fatherName;
    }

    public Date getBirthday() {

        return this.birthday;
    }
}
