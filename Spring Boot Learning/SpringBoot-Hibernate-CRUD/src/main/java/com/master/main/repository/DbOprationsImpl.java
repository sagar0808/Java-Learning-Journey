package com.master.main.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.master.main.Config.HibernateConfig;
import com.master.main.Entities.User;

@Repository
public class DbOprationsImpl implements DbOperations{

	@Override
	public User getUserById(int id) {
		User user = null;
		try(Session session = HibernateConfig.sessionFactory().openSession()) {
			user = session.get(User.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public Boolean createUser(User user) {
		Boolean status = false;
		Transaction transaction = null;
		try(Session session = HibernateConfig.sessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			
			session.persist(user);
			transaction.commit();
			status = true;
			
		} catch (Exception e) {
			transaction.rollback();
			status = false;
			e.printStackTrace();
		}
		return status;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Boolean updateUserById(int id, User user) {
		boolean status = false;
		Transaction transaction = null;
		try(Session session = HibernateConfig.sessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			
			session.update(user);
			transaction.commit();
			status = true;
			
		} catch (Exception e) {
			transaction.rollback();
			status = false;
			e.printStackTrace();
		}
		return status;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Boolean deleteUserById(User user) {
		Boolean status = false;
		Transaction transaction = null;
		try(Session session = HibernateConfig.sessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			
			session.delete(user);
			transaction.commit();
			status = true;
			
		} catch (Exception e) {
			status = false;
			transaction.rollback();
			e.printStackTrace();
		}
		return status;
	}

}
