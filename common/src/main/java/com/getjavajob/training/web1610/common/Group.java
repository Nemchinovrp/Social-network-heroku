package com.getjavajob.training.web1610.common;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "groups")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Group extends EntryId {
    @Column(name = "name")
    private String name;
    @OneToOne
    @JoinColumn(name = "id_owner", referencedColumnName = "id")
    private Account owner;
    @Column(name = "info")
    private String info;
    @Column(name = "logo")
    private byte[] logo;

    public Group(int i, String name, Account owner, String info) {
        this.setId(i);
        this.name = name;
        this.owner = owner;
        this.info = info;
    }
}