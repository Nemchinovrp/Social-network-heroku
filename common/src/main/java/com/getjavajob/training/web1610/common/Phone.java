package com.getjavajob.training.web1610.common;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "phone")
@XStreamAlias("phone")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Phone extends EntryId {
    @Column(name = "type")
    @XStreamAlias("type")
    private String phoneType;
    @Column(name = "number")
    @XStreamAlias("number")
    private String number;
}