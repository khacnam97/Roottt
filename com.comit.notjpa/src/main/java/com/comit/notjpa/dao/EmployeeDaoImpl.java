package com.comit.notjpa.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.comit.notjpa.entities.Employee;

@Repository
public class EmployeeDaoImpl extends AbstractDao implements EmployeeDao {
	
    
	@Override
	public Employee findByPk(Long id) {
		Session session = sessionFactory.getCurrentSession();
        return (Employee) session.get(Employee.class, id);
	}

	@Override
	public Employee update(Employee employee) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(employee);
		return null;
	}

	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(employee);
	}

	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(employee);
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Employee");
		List<Employee> empList = query.list();
        return empList;
 
	}
	

}
