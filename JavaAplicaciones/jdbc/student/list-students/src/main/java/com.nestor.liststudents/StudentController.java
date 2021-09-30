package com.nestor.liststudents;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean
@SessionScoped
public class StudentController {
    private List<Student> students;
    private final StudentDbUtil studentDbUtil;
    private final Logger logger = Logger.getLogger(getClass().getName());

    public StudentController() throws Exception {
        students = new ArrayList<>();
        studentDbUtil = StudentDbUtil.getInstance();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void loadStudents() {
        logger.info("Loading students");
        students.clear();
        try {
            // get all students from database
            students = studentDbUtil.getStudents();
        } catch (Exception exc) {
            // send this to server logs
            logger.log(Level.SEVERE, "Error loading students", exc);
            // add error message for JSF page
            addErrorMessage(exc);
        }
    }

    private void addErrorMessage(Exception exc) {
        FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
