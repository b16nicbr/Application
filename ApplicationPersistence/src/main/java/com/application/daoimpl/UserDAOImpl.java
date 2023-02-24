package com.application.daoimpl;

import com.application.dao.UserDAO;
import com.application.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

@Service("UserDAOImpl")
public class UserDAOImpl implements UserDAO {


    @Override
    public void insert(UserDAO user) {
        Transaction transaction = null;
        Session session = HibernateSessionFactoryUtil.getSession();
        try
        {
            transaction=session.beginTransaction();
            session.persist(user);

            transaction.commit();

        }
        catch(RuntimeException re)
        {
            if(transaction!=null)
                transaction.rollback();
            throw re;
        }
        finally
        {
            session.close();
        }
    }

    @Override
    public void update(UserDAO user) {
        Transaction transaction = null;
        Session session = HibernateSessionFactoryUtil.getSession();
        try
        {
            transaction=session.beginTransaction();
            session.merge(user);

            transaction.commit();

        }
        catch(RuntimeException re)
        {
            if(transaction!=null)
                transaction.rollback();
            throw re;
        }
        finally
        {
            session.close();
        }

    }

    @Override
    public void delete(UserDAO user) {
        Transaction transaction = null;
        Session session = HibernateSessionFactoryUtil.getSession();
        try
        {
            transaction=session.beginTransaction();
            session.remove(user);

            transaction.commit();

        }
        catch(RuntimeException re)
        {
            if(transaction!=null)
                transaction.rollback();
            throw re;
        }
        finally
        {
            session.close();
        }
    }
}
