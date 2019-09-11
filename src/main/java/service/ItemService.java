package service;

import dao.ItemDAO;
import model.Item;
import org.hibernate.HibernateException;

public class ItemService {
    private ItemDAO itemDAO = new ItemDAO();

    public Item create(Item item) throws HibernateException {
        return itemDAO.save(item);
    }

    public Item read(long id) throws HibernateException {
        return itemDAO.findById(id);
    }

    public Item update(Item item) throws HibernateException {
        return itemDAO.update(item);
    }

    public void delete(long id) throws HibernateException {
        itemDAO.delete(id);
    }
}
