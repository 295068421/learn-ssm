package com.kaishengit.test;

import com.kaishengit.pojo.Card;
import com.kaishengit.pojo.Person;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

public class OneToOneTestCase {

    @Test
    public void testFind() {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        /*Person person = (Person) session.get(Person.class,2);
        System.out.println(person.getName());
        System.out.println(person.getCard().getCardname());*/

        Card card = (Card) session.get(Card.class,2);
        System.out.println(card.getCardname());
        System.out.println(card.getPerson().getName());


        session.getTransaction().commit();
    }


    @Test
    public void testSave() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Person person = new Person();
        person.setName("张三");

        Card card = new Card();
        card.setCardname("VIP-01");
        card.setPerson(person);


        session.save(card);
        //session.save(person);


        session.getTransaction().commit();
    }


    @Test
    public void testDel() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Person person = (Person) session.get(Person.class,8);
        session.delete(person);

        session.getTransaction().commit();
    }
}
