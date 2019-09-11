package controller;

import model.Item;
import org.hibernate.HibernateException;
import service.ItemService;

public class ItemController {
    private ItemService itemService = new ItemService();

    public Item create(Item item) throws HibernateException {
        return itemService.create(item);
    }

    public Item read(long id) throws HibernateException {
        return itemService.read(id);
    }

    public Item update(Item item) throws HibernateException {
        return itemService.update(item);
    }

    public void delete(long id) throws HibernateException {
        itemService.delete(id);
    }
}
