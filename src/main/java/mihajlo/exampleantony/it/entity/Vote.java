package mihajlo.exampleantony.it.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    User user;
    @ManyToOne
    Poll poll;
    @OneToMany
    List<Place> places = new ArrayList<>();

    public Vote(User user, Poll poll) {
        this.user = user;
        this.poll = poll;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}
