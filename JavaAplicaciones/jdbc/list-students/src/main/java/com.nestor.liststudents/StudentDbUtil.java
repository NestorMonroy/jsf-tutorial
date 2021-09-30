package com.nestor.liststudents;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class StudentDbUtil {

    private static StudentDbUtil instance;
    private final DataSource dataSource;
    private final String jndiName = "java:comp/env/jdbc/student_tracker";

    //Singleton Pattern
    public static StudentDbUtil getInstance() throws Exception {
        if (instance == null) {
            instance = new StudentDbUtil();
        }

        return instance;
    }

    private StudentDbUtil() throws Exception {
        dataSource = getDataSource();
    }

    private DataSource getDataSource() throws NamingException {
        Context context = new InitialContext();
        //TomCat
        DataSource theDataSource = (DataSource) context.lookup(jndiName);
        return theDataSource;
    }

    public List<Student> getStudents() throws Exception {
        List<Student> students = new ArrayList<>();
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = getConnection();
            String sql = "select * from student order by last_name";
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery(sql);
            // process result set
            while (myRs.next()) {
                // retrieve data from result set row
                int id = myRs.getInt("id");
                String firstName = myRs.getString("first_name");
                String lastName = myRs.getString("last_name");
                String email = myRs.getString("email");
                // create new student object
                Student tempStudent = new Student(id, firstName, lastName, email);
                // add it to the list of students
                students.add(tempStudent);
            }
            return students;
        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    private Connection getConnection() throws Exception {
        Connection theConn = dataSource.getConnection();
        return theConn;
    }

    private void close(Connection theConn, Statement theStmt) {
        close(theConn, theStmt, null);
    }

    private void close(Connection theConn, Statement theStmt, ResultSet theRs) {
        try {
            if (theRs != null) {
                theRs.close();
            }
            if (theStmt != null) {
                theStmt.close();
            }
            if (theConn != null) {
                theConn.close();
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}

