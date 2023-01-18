package Repositories;


import HibernateCfg.HibernateConfig;
import Model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDao {

    public void addUser(User user){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.save(user);

            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers(){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Query<User> query = session.createQuery("from User ", User.class);

            List<User> list = query.getResultList();
            transaction.commit();
            return list;

        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    public void deleteUser(User user){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            user = (User) session.get(User.class, user.getId());
            session.delete(user);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void editUser(User user){
        Transaction transaction = null;
        Session session = HibernateConfig.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            User user1 = (User) session.get(User.class,user.getId());
            user1.setFirstName(user.getFirstName());
            user1.setLastName(user.getLastName());
            user1.setEmail(user.getEmail());
            session.update(user1);
            transaction.commit();

        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
    }


}
