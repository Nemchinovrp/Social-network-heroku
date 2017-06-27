package com.getjavajob.training.web1610.common;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@XStreamAlias("account")
@Entity
@Table(name = "account")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Account extends EntryId {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "home_address")
    private String homeAddress;
    @Column(name = "working_address")
    private String workingAddress;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    @XStreamOmitField
    private String password;
    @Column(name = "icq")
    @XStreamOmitField
    private String icq;
    @XStreamOmitField
    @Column(name = "skype")
    private String skype;
    @Column(name = "info")
    private String info;
    @Column(name = "foto")
    @XStreamOmitField
    private byte[] foto;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_account", nullable = false)
    @XStreamImplicit(itemFieldName = "phone")
    private List<Phone> phones;
    @XStreamOmitField
    @OneToMany(mappedBy = "sender", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Friendship> sender;
    @XStreamOmitField
    @OneToMany(mappedBy = "receiver", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Friendship> receiver;

    public Account() {
    }

    public Account(int id, String firstName, String lastName) {
        this.setId(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Account(int id, String firstName, String lastName, String email, String password) {
        this.setId(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Account(String firstName, String middleName, String lastName, Date dateOfBirth, String homeAddress, String workingAddress, String email, String password, String icq, String skype, String info) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.homeAddress = homeAddress;
        this.workingAddress = workingAddress;
        this.email = email;
        this.password = password;
        this.icq = icq;
        this.skype = skype;
        this.info = info;
    }

    public Account(int id, String firstName, String middleName, String lastName, Date dateOfBirth, String homeAddress, String workingAddress, String email, String password, String icq, String skype, String info) {
        this.setId(id);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.homeAddress = homeAddress;
        this.workingAddress = workingAddress;
        this.email = email;
        this.password = password;
        this.icq = icq;
        this.skype = skype;
        this.info = info;
    }
}