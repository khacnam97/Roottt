package com.comit.notjpa.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.comit.notjpa.dto.EmployeeDto;
import com.comit.notjpa.entities.Employee;

@Repository
public class EmployeeDaoImpl extends AbstractDao implements EmployeeDao {

	@Override
	public Employee findByPk(Long id) {
		Session session = sessionFactory.getCurrentSession();
        return (Employee)session.get(Employee.class,id);
	}

	@Override
	public Employee update(Employee emp) {
		Session session = sessionFactory.getCurrentSession();
		session.update(emp);
		return null;
	}

	@Override
	public Employee delete(Long id) {
		Session session ;
		Employee emp ;
	    session = sessionFactory.getCurrentSession();
	    emp = (Employee)session.load(Employee.class,id);
	    session.delete(emp);
	    session.flush() ;
		return null;
	}

	@Override
	public Employee save(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
//		Employee empl = new Employee();
//		empl.setFirst_name(employee.getFirst_name());
//		empl.setLast_name(employee.getLast_name());
//		empl.setEmail(employee.getEmail());
//		empl.setJob_id(employee.getJob_id());
//		System.out.println(empl.getFirst_name());
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

	@Override
	public Employee edit(Long id, Model model) {
		Session session ;
		Employee emp ;
	    session = sessionFactory.getCurrentSession();
	    return emp = (Employee)session.load(Employee.class,id);
	}

}
