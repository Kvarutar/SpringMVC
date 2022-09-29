package ru.mvc.daoInterface;

import ru.mvc.entities.Customers;

import java.util.List;

public interface CustomerDao {
    public List<Customers> getAllCustomers();
}
