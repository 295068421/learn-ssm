package com.kaishengit.pojo;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "t_card")
public class Card implements Serializable {

    @Id
    @GenericGenerator(name = "FK",strategy = "foreign",parameters = {
            @org.hibernate.annotations.Parameter(name = "property",value = "person")
    })
    @GeneratedValue(generator = "FK")
    private Integer id;
    private String cardname;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Person person;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
