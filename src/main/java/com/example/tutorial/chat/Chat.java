package com.example.tutorial.chat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;
    private LocalDate date;
    private LocalTime time;
    private String input;

    public Chat() {
        this.date = LocalDate.now();
        this.time = LocalTime.now();
    }

    public Chat(String input) {
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.input = input;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = LocalDate.now();
    }

    public void setTime(LocalTime time) {
        this.time = LocalTime.now();
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", date=" + date +
                ", time=" + time +
                ", input='" + input + '\'' +
                '}';
    }
}
