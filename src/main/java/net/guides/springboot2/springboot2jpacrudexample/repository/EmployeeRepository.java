package net.guides.springboot2.springboot2jpacrudexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.guides.springboot2.springboot2jpacrudexample.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	public List<Employee> findByDepartment(String department);
	
	@Query("from Employee e order by e.firstName")
	public List<Employee> sortByFirstName();
	//public List<Employee> findByFirstNameSorted();
	
	
}
