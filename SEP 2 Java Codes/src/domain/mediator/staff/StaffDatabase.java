package domain.mediator.staff;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import domain.model.staff.Doctor;
import domain.model.staff.Employee;
import domain.model.staff.EmployeeFactory;
import domain.model.staff.EmployeeList;
import domain.model.staff.Manager;
import domain.model.staff.Secretary;
import domain.model.staff.Type;
import utility.persistence.MyDatabase;

public class StaffDatabase implements StaffPersistence {
    private MyDatabase db;
    private final String DRIVER = "org.postgresql.Driver";
    private final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String USER = "postgres";
    private final String PASSWORD = "0940";
    public StaffDatabase() throws ClassNotFoundException {
        this.db = new MyDatabase(DRIVER, URL, USER, PASSWORD);
    }
    public EmployeeList loadEmployeesByName(String name) throws IOException {
        String sql = "SELECT * FROM \"Clinic\".employee WHERE firstname = '" + name + "';";
        ArrayList<Object[]> results;
        EmployeeList employees = new EmployeeList();
        int id = 0;
        String firstname = " ";
        String lastname = " ";
        Date dob;
        Date startdate;
        String telnumber = " ";
        String email = " ";
        String gender = " ";
        String username = "";
        String employeepassword = "";
        try {
            results = db.query(sql);
            for (int i = 0; i < results.size(); i++) {
                Object[] row = results.get(i);
                id = Integer.parseInt(row[0].toString());
                firstname = row[1].toString();
                if(firstname!=null && firstname.length()>1) {
                        
                    firstname=firstname.substring(0, 1).toUpperCase()
                        + row[1].toString().substring(1).toLowerCase();
                }
                lastname = row[2].toString();
                dob = (Date) row[3];
                startdate = (Date) row[4];
                telnumber = row[5].toString();
                email = row[6].toString();
                gender = row[7].toString();
                Type employeeType = Type.valueOf(row[8].toString());
                username = row[9].toString();
                employeepassword = row[10].toString();
                Employee employee = EmployeeFactory.create(id, firstname, lastname, dob, startdate, telnumber, email,
                        gender, employeeType, username, employeepassword);
                employees.addEmployee(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
    
    
    
    
    
    
    
      public ArrayList<Employee> loadLogIn() {
          String sql = "SELECT * FROM \"Clinic\".employee;";
          ArrayList<Object[]> results;
          ArrayList<Employee> employees = new ArrayList<Employee>();
          String username = "";
          String employeepassword = "";
          try {
             results = db.query(sql);
             for (int i = 0; i < results.size(); i++) {
                Object[] row = results.get(i);
                username = row[9].toString();
                employeepassword = row[10].toString();
                Type employeeType = Type.valueOf(row[8].toString());
                Employee employee = EmployeeFactory.create(0, "", "", null, null, "", "", "", employeeType, username,
                      employeepassword);
                
                employees.add(employee);
             }
          } catch (SQLException e) {
             e.printStackTrace();
          }
          return employees;
       }
    public void save(Employee employee) throws IOException {
        {
            String type = "";
            if (employee instanceof Doctor) {
                type = "Doctor";
            } else if (employee instanceof Secretary) {
                type = "Secretary";
            } else if (employee instanceof Manager) {
                type = "Manager";
            }
            java.sql.Date sqlDate = null;
                if(employee.getDob()!=null) {
            sqlDate = new java.sql.Date(employee.getDob().getTime());
                }
            java.sql.Date sqlStartDate= null;
            if (employee.getStartDate()!= null) {
            sqlStartDate= new java.sql.Date(employee.getStartDate().getTime());}
            
            String firstName =  employee.getFirstName();
            if(firstName!= null && firstName.length()>1) {
                firstName= firstName.substring(0, 1).toUpperCase()
                    + employee.getFirstName().substring(1);
            }
            try {
                String sql = "INSERT INTO \"Clinic\".employee (firstname, lastname, dob, startdate, telnumber, email, gender,employeetype,username,employeepassword )"
                        + "VALUES (? , ? , ? , ? , ? , ?, ? , ?,?,?);";
                db.update(sql, firstName, employee.getLastName(), sqlDate, sqlStartDate, employee.getTelNumber(),
                        employee.getEamil(), employee.getGender(), type, employee.getUserName(),
                        employee.getPassword());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void remove(Employee employee) {
        int id = employee.getId();
        String sql = "delete FROM \"Clinic\".employee WHERE employeeid = ?;";
        try {
            db.update(sql, id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void updateEmployee(Employee employee) {
       
       try
     {

          String sql = "UPDATE \"Clinic\".employee  SET firstname = ? , lastname = ?, dob = ?, startdate = ?, telnumber = ?, email = ?, gender = ?   where employeeid = '" + employee.getId() + "';";
        
        db.update(sql, employee.getFirstName(), employee.getLastName(), employee.getDob(), employee.getStartDate(), employee.getTelNumber(), employee.getEmail(), employee.getGender());

     }
     catch (SQLException e)
     {
        e.printStackTrace();
     }
   
 }
}