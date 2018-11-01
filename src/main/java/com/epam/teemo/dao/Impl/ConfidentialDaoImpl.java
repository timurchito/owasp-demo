package com.epam.teemo.dao.Impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.epam.teemo.dao.ConfidentialDao;
import com.epam.teemo.entity.Confidential;


@Repository
@Qualifier("normal")
@Transactional
public class ConfidentialDaoImpl implements ConfidentialDao
{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Confidential> find(String id)
	{
		Session session = this.sessionFactory.getCurrentSession();
		TypedQuery<Confidential> query = session.getNamedQuery("findConfidentialById");
		query.setParameter("id", id);
		return query.getResultList();
	}
}
