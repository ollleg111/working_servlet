package service;

import dao.ItemDAO;
import model.Item;

public class ItemService {
    private ItemDAO itemDAO = new ItemDAO();

    public Item create(Item item) {
        return itemDAO.save(item);
    }

    public Item read(long id) {
        return itemDAO.findById(id);
    }

    public Item update(Item item) {
        return itemDAO.update(item);
    }

    public void delete(long id) {
        itemDAO.delete(id);
    }
}
