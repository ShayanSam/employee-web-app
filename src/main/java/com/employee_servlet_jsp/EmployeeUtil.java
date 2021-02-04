package com.employee_servlet_jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmployeeUtil {

    public void addEmployee(Employee employee){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        em.persist(employee);
        entityTransaction.commit();

    }

    public void addEmployeeINF(EmployeeINF employeeINF){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        em.persist(employeeINF);
        entityTransaction.commit();

    }

    public List<Employee> getAllEmployees(){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = cb.createQuery(Employee.class);
        Root<Employee> allEmployees = criteriaQuery.from(Employee.class);
        criteriaQuery.select(allEmployees);
        return em.createQuery(criteriaQuery).getResultList();

    }

    public void updateEmployINF(int empId, EmployeeINF employeeINF){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        Employee employee = em.find(Employee.class,empId);
        employee.setEmployeeINF(employeeINF);
        entityTransaction.commit();

    }

    public List<EmployeeINF> getEmployeeINF(){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<EmployeeINF> criteriaQuery = cb.createQuery(EmployeeINF.class);
        Root<EmployeeINF> allEmployeesINF = criteriaQuery.from(EmployeeINF.class);
        criteriaQuery.select(allEmployeesINF);
        return em.createQuery(criteriaQuery).getResultList();
    }

    public void deleteEmployee(int id){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        Employee employee = em.find(Employee.class,id);
        em.remove(employee);
        entityTransaction.commit();
    }

    public void updateEmployee(Employee employee, int empId) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        Employee tempEmployee = em.find(Employee.class, empId);
        tempEmployee.setFirstName(employee.getFirstName());
        tempEmployee.setLastName(employee.getLastName());
        entityTransaction.commit();

    }

    public void deleteEmployeeINF(int id){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        EmployeeINF employeeINF = em.find(EmployeeINF.class,id);
        em.remove(employeeINF);
        entityTransaction.commit();
    }

}
