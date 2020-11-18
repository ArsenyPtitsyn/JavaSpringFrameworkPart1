package ru.geekbrains.hibernate.shop;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.geekbrains.hibernate.PrepareDataApp;

import java.util.List;

public class ShopApp {
    public static void main(String[] args) {
        PrepareDataApp.forcePrepareData();

        SessionFactory factory = new Configuration()
                .configure("configs/shop/hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Customer customer = session.get(Customer.class, 1L);
            System.out.println(customer);
            System.out.println("Goods: ");
            for (Good g : customer.getGoods()) {
                System.out.println(g.getTitle());
            }

            List<Customer> customers = session
                    .createQuery("SELECT c FROM Customer c ORDER BY size(c.goods) DESC")
                    .getResultList();
            System.out.println(customers);
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            List<Good> allGoods = session.createQuery("SELECT g FROM Good g").getResultList();
            Customer c = session.get(Customer.class, 2L);
            allGoods.stream().forEach(b -> {
                if(b.getId() > 4 && b.getId() < 8) {
                    c.getGoods().add(b);
                }
            });
            c.getGoods().clear();
            session.getTransaction().commit();
            System.out.println(1);
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("DELETE FROM Good g WHERE g.id = 1").executeUpdate();
            session.getTransaction().commit();
            System.out.println(2);
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            System.out.println(session.createQuery("SELECT b.title FROM Book b WHERE b.id = 1", String.class).getSingleResult());
//            session.getTransaction().commit();
//
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            List<Book> books = session.createQuery("FROM Book").getResultList();
//            session.getTransaction().commit();
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }
}