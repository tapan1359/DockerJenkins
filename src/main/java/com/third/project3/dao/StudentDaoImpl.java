package com.third.project3.dao;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.Transaction;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.third.project3.model.Student;

@Component
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory factory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudents() {

		Criteria criteria=factory.openSession().createCriteria(Student.class);
		return criteria.list();
	}
	
	public Student getStudentById(int id )
	{
		Student st = null;
		Criteria criteria = factory.openSession().createCriteria(Student.class);
		// Criterion price = Restrictions.gt("i",new Double(25.0));
		criteria.add(Restrictions.eq("id", id));
		criteria.setMaxResults(1);
		st = (Student) criteria.uniqueResult();
		return st;
}

	
	public String save(Student st) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(st);
		tx.commit();
		session.close();
		return "created!!";
	}
	
	public String update(Student st) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(st);
		tx.commit();
		session.close();
		return st + "updated!!";
	}

	@Override
	public String delete(int id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Student st = (Student)session.createCriteria(Student.class).add( Restrictions.eq("id", id)).uniqueResult();
		session.delete(st);
		tx.commit();
		session.close();
		return st.getId() + "--" + "Deleted!!";
	}
	
	
}
