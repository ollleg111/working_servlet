package controller;

import model.Item;
import service.ItemService;

public class ItemController {
    private ItemService itemService = new ItemService();

    public Item create(Item item) {
        return itemService.create(item);
    }

    public Item read(long id) {
        return itemService.read(id);
    }

    public Item update(Item item) {
        return itemService.update(item);
    }

    public void delete(long id) {
        itemService.delete(id);
    }
}
