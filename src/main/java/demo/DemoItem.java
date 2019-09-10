package demo;

import controller.ItemController;
import model.Item;

import java.util.Date;

public class DemoItem {
    public static void main(String[] args) {
        ItemController itemController = new ItemController();

        /*
        Long id
        String name
        Date dateCreated
        Date lastUpdatedDate
        String description
        */

//        Item item = new Item();
//        item.setName("alex");
//        item.setDateCreated(new Date());
//        item.setLastUpdateDate(new Date());
//        item.setDescription("aaa bbb ccc");
//
//
//        try {
//            itemController.create(item);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try{
            itemController.read(101);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
