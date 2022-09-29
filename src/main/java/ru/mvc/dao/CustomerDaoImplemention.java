package ru.mvc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Repository;
import ru.mvc.daoInterface.CustomerDao;
import ru.mvc.entities.Customers;

import java.util.List;

@Repository
public class CustomerDaoImplemention implements CustomerDao {
//    private SessionFactory sessionFactory;
//
//    public CustomerDaoImplemention(SessionFactory sessionFactory){
//        this.sessionFactory = sessionFactory;
//    }

    @Override
    public List<Customers> getAllCustomers() {
        return null;
    }
}
