package com.nestor.validatedemo;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
public class StudentFour {
    private String firstName;
    private String lastName;
    private String courseCode;

    // create no-arg constructor
    public StudentFour() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void validateTheCourseCode(FacesContext context,
                                      UIComponent component,
                                      Object value) throws ValidatorException {
        if (value == null) {
            return;
        }
        String data = value.toString();
        // Course code must start with NES ... if not, throw exception
        if (!data.startsWith("NES")) {
            FacesMessage message = new FacesMessage("Course code must start with NES");
            throw new ValidatorException(message);
        }
    }
}
