package hu.gyak.beadando.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;
    @Column
    private String subject;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private LocalDateTime dateTime;

    public Message() {
    }

    public Message(User user, String content) {
        this.user = user;
        this.content = content;
    }

    public Message(User user, String subject, String content) {
        this.user = user;
        this.subject = subject;
        this.content = content;
    }

    public Long getId() {
        return Id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
