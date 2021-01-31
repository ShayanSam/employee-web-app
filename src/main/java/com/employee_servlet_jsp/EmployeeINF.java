package com.employee_servlet_jsp;

import javax.persistence.*;
import java.io.*;

@Entity
public class EmployeeINF implements Externalizable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_inf_id")
    private Integer id;

    @Column(name = "fathers_name")
    private String fathersName;

    @Column(name = "national_code")
    private String nationalCode;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String Address;

    @OneToOne(mappedBy = "employeeINF")
    @JoinColumn(name = "emp_id")
    private Employee employee;

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public Integer getId() {
        return id;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Father's name: ").append(fathersName).append(" || ").append("NCode: ").append(nationalCode).append(" || ")
                .append("PhoneN: ").append(phoneNumber).append(" || ").append("Address: ").append(Address);
        String info = stringBuilder.toString();
        return info;
    }
}
