package com.autotest.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.autotest.dao.HibernateSessionFactory;

/**
 * HQL”Ôæ‰π§æﬂ¿‡
 * @author emanon
 *
 */
public class HQLUtil {

	public static List search(String hql) {
		List result = new ArrayList();
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		result = query.list();
		return result;
	}
}
