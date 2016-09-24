package mum.store.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.StringProperty;

public class Employee {
	private StringProperty empName;
    private StringProperty empAddress;
    private StringProperty empEmail;
    private StringProperty userName;
    private StringProperty password;
    private LongProperty empId;
    private IntegerProperty roleId;
    
    public Employee()
    {}
    
    public String getEmpName() {
        return empName.get();
    }

    public void setEmpName(String empName) {
        this.empName.set(empName);
    }

    public StringProperty empNameProperty() {
        return empName;
    }
    
    public String getEmpAddress() {
        return empAddress.get();
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress.set(empAddress);
    }

    public StringProperty empAddressProperty() {
        return empAddress;
    }
    
    public String getEmpEmail() {
        return empEmail.get();
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail.set(empEmail);
    }

    public StringProperty empEmailProperty() {
        return empEmail;
    }
    
    public String getUserName() {
        return userName.get();
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public StringProperty empUserNameProperty() {
        return userName;
    }
    
    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public StringProperty empPasswordProperty() {
        return password;
    }
    public Integer getRoleId() {
        return roleId.get();
    }

    public void setRoleId(Integer roleId) {
        this.roleId.set(roleId);
    }

    public IntegerProperty roleIdProperty() {
        return roleId;
    }
    public Long getEmpId() {
        return empId.get();
    }

    public void setEmpId(Long empId) {
        this.empId.set(empId);
    }

    public LongProperty empIdProperty() {
        return empId;
    }
}
