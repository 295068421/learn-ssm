package com.kaishengit.test;

import com.kaishengit.pojo.Dept;
import com.kaishengit.pojo.Employee;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class OneToManyTestCase {

    @Test
    public void testFindDeptById() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Dept dept = (Dept) session.get(Dept.class,9);
        System.out.println(dept.getDeptname());

        Set<Employee> employeeList = dept.getEmployees();
        for(Employee employee : employeeList) {
            System.out.println(employee.getId() + " -> " + employee.getEmpname());
        }

        session.getTransaction().commit();
    }

    @Test
    public void testFindEmployeeById() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Employee employee = (Employee) session.get(Employee.class,17);
        System.out.println(employee.getEmpname());
        System.out.println(employee.getDept().getDeptname());


        session.getTransaction().commit();
    }

    @Test
    public void saveEmployee() {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Dept dept = new Dept();
        dept.setDeptname("销售部");

        Employee employee = new Employee();
        employee.setEmpname("张三");

        employee.setDept(dept);


        session.save(dept);
        session.save(employee);

        session.getTransaction().commit();

    }


    @Test
    public void delDept() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Dept dept = (Dept) session.get(Dept.class,12);
        session.delete(dept);

        session.getTransaction().commit();
    }




}
