package ca.bc.gov.sdpr.ccof.dao.security.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ca.bc.gov.sdpr.ccof.dao.security.UserDAO;
import ca.bc.gov.sdpr.ccof.model.security.User;
import ca.bc.gov.sdpr.ccof.ui.model.security.UserUI;

@Component("UserDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	public SessionFactory orbeonWSSessionFactory;

	@Override
	@Transactional(readOnly = true)
	public User get(String id) {
		Session session = orbeonWSSessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> queryCriteria = builder.createQuery(User.class);
		
		Root<User> from = queryCriteria.from(User.class);
		queryCriteria.select(from);
		queryCriteria.where(builder.equal(from.get("id"), id));
		
		Query<User> query = session.createQuery(queryCriteria);
		return query.uniqueResult();
	}
	
	@Override
	@Transactional(readOnly = true)
	public User getUser(String userId) {

		Session session = orbeonWSSessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> queryCriteria = builder.createQuery(User.class);
		Root<User> root = queryCriteria.from(User.class);
		queryCriteria.select(root);
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (null != userId) {
			predicates.add(builder.equal(root.get("userId"), userId));
		}
		queryCriteria.where(predicates.toArray(new Predicate[predicates.size()]));
		Query<User> query = session.createQuery(queryCriteria);
		return query.getSingleResult();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@Transactional(readOnly = true)
	public List<User> getAllUsers() {
//		String sql = "SELECT * FROM app_auth_user";
//		NativeQuery query = orbeonWSSessionFactory.getCurrentSession().createNativeQuery(sql);
//		List<User> users = query.getResultList();
//		return users;
		
		Session session = orbeonWSSessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> queryCriteria = builder.createQuery(User.class);
		Root<User> root = queryCriteria.from(User.class);
		queryCriteria.select(root);
		
		Query<User> query = session.createQuery(queryCriteria);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<User> getGroupUsers(String groupId) {
		Criteria criteria = orbeonWSSessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.createCriteria("userGroup").add(Restrictions.isNotNull("group")).createCriteria("group")
				.add(Restrictions.eq("id", groupId));
		return criteria.list();
	}

	@Override
	@Transactional
	public User saveUser(User user) {
		orbeonWSSessionFactory.getCurrentSession().saveOrUpdate(user);
		return user;
	}

	@Override
	@Transactional
	public boolean delete(String id) {
		Session session = orbeonWSSessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		if(null != user) {
			session.delete(user);
		}else {
			return false;
		}
		return true;
	}

	@Override
	@Transactional
	public boolean updateUser(UserUI userUI) {
		Session session = orbeonWSSessionFactory.getCurrentSession();
		User user = session.get(User.class, userUI.getId());
		
		//Perform Replace
		user.setId(userUI.getId());
		user.setUserId(userUI.getUserId());
		user.setEmail(userUI.getEmail());
		user.setFirstname(userUI.getFirstName());
		user.setIsactive(userUI.getIsActive());
		user.setLastname(userUI.getLastName());
		user.setPhone(userUI.getPhone());
		user.setUsertype(userUI.getUserType());
		try {
			session.saveOrUpdate(user);
			return true;
		}catch (Exception e) {
			
		}
		return false;
	}

}
