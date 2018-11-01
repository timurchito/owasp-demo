package com.epam.teemo.dao.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.epam.teemo.dao.ConfidentialDao;
import com.epam.teemo.entity.Confidential;


@Repository
@Qualifier("injection")
@Transactional
public class InjectionConfidentialDaoImpl implements ConfidentialDao
{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<Confidential> find(String id)
	{
		Session session = sessionFactory.getCurrentSession();
		String queryString = "from Confidential where id = '" + id + "'";
		Query query = session.createQuery(queryString);
		return query.getResultList();
	}

	@Deprecated
	public List<Confidential> findJDDC(String id)
	{
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "security_demo";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "root";
		try {
			Class.forName(driver).newInstance();
			connection = DriverManager.getConnection(url + dbName, userName, password);

			statement = connection.createStatement();
			String query = "SELECT * FROM demo_table where id=" + id + "";
			resultSet = statement.executeQuery(query);

			List<Confidential> result = new ArrayList<>();

			while (resultSet.next()) {
				Confidential confidential = new Confidential();
				confidential.setId(resultSet.getString("id"));
				confidential.setName(resultSet.getString("name"));
				confidential.setConfidentialInfo(resultSet.getString("confidential"));
				result.add(confidential);
			}
			return result;


		} catch (Exception e) {
			if (connection != null) {
				try
				{
					connection.close();
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		return null;
	}

}
