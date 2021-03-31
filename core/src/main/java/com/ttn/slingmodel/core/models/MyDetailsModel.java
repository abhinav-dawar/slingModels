package com.ttn.slingmodel.core.models;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
@Model(adaptables = Resource.class)
public class MyDetailsModel {
    @Inject
    private String fname;

    @Inject
    private String lname;

    @Inject
    private String dob;

    @Inject
    private  String gender;

    @Inject
    private String maritalstatus;

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getMaritalstatus() {
        return maritalstatus;
    }

    public String getFullName()
    {
        return fname + " "+ lname;
    }

    public int getAge() throws ParseException {

        String dob=getDob();
        LocalDate Dob=LocalDate.parse(dob);

        LocalDate currentDate=LocalDate.now();
        int age=Period.between(Dob,currentDate).getYears();

       return age;
    }

    public String getHonorific()
    {
        String gender=getGender();
        String maritalStatus=getMaritalstatus();

        if(gender.equals("male"))
        {
            return "Mr";
        }
        else if(gender.equals("female") && maritalStatus.equals("single"))
        {
            return "Ms";
        }
        else
        {
            return "Mrs";
        }
    }
}
