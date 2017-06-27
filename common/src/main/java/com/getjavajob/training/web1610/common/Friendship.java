package com.getjavajob.training.web1610.common;

import javax.persistence.*;

@Entity
@Table(name = "friendship")
public class Friendship extends EntryId {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_acc")
    private Account sender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_friend")
    private Account receiver;

    @Enumerated(EnumType.STRING)
    private Status status;


    public Friendship() {
    }

    public Friendship(Account sender, Account receiver, Status status) {
        this.sender = sender;
        this.receiver = receiver;
        this.status = status;
    }


    public Account getSender() {
        return sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public void setReceiver(Account receiver) {
        this.receiver = receiver;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
