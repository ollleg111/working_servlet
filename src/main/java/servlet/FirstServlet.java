package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.ItemController;
import exceptions.BadRequestException;
import exceptions.EntityNotFoundException;
import exceptions.NotFoundException;
import model.Item;
import org.hibernate.HibernateException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(urlPatterns = "/test")
public class FirstServlet extends javax.servlet.http.HttpServlet {

    private ItemController itemController = new ItemController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//
//        resp.getWriter().println("jbkdjb;lkenfll");

        try {
            ObjectMapper mapper = new ObjectMapper();
            long id = Long.parseLong(req.getParameter("id"));

            resp.setStatus(200);
            mapper.writeValue(resp.getWriter(), itemController.read(id));

        } catch (NumberFormatException e1) {
            resp.setStatus(400);
            resp.getWriter().println("may be you entered with syntactic error " + e1.getMessage() +
                    " in method doGet");

        } catch (NotFoundException e2) {
            resp.setStatus(404);
            resp.getWriter().println("not found " + e2.getMessage() + " in method doGet");

        } catch (HibernateException e3) {
            resp.setStatus(500);
            resp.getWriter().println("internal server error " + e3.getMessage() + " in method doGet");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Item item = getItem(req);
            itemController.update(item);

            resp.setStatus(200);
            resp.getWriter().println("id: " + item.getId() + " is updated");

        } catch (BadRequestException e1) {
            resp.setStatus(400);
            resp.getWriter().println("may be you entered with syntactic error " + e1.getMessage() +
                    " in method doPut");

        } catch (Exception e2) {
            resp.setStatus(500);
            resp.getWriter().println("update item was filed" + e2.getMessage() + " in method doPut");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Item item = getItem(req);
            itemController.create(item);

            resp.setStatus(201);
            resp.getWriter().println("item id: " + item.getId() + " is created");

        } catch (BadRequestException e1) {
            resp.setStatus(400);
            resp.getWriter().println("may be you entered with syntactic error " + e1.getMessage() +
                    " in method doPost");

        } catch (Exception e2) {
            resp.setStatus(500);
            resp.getWriter().println("saving item was filed" + e2.getMessage() + " in method doPost");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            long id = Long.parseLong(req.getParameter("id"));
            itemController.delete(id);

            resp.setStatus(200);
            resp.getWriter().println("id: " + id + " was deleted");

        } catch (NumberFormatException e1) {
            resp.setStatus(400);
            resp.getWriter().println("may be you entered with syntactic error " + e1.getMessage() +
                    " in method doDelete");

        } catch (EntityNotFoundException e2) {
            resp.setStatus(404);
            resp.getWriter().println("not found entity " + e2.getMessage()
                    + " in method doDelete");

        } catch (HibernateException e3) {
            resp.setStatus(500);
            resp.getWriter().println("deleting item was filed " + e3.getMessage() + " in method doDelete");
        }
    }

    private Item getItem(HttpServletRequest req) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(req.getReader(), Item.class);
    }
}
