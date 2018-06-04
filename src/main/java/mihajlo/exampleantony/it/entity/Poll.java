package mihajlo.exampleantony.it.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Entity
@Table(name = "polls")
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToMany(fetch = FetchType.EAGER)
    Set<User> users = new HashSet<>();
    @ManyToMany(fetch = FetchType.EAGER)
    Set<Place> places = new HashSet<>();
    Date dateCreated;
    Date dateEnding;
    @ManyToOne
    User userCreated;
    String description;
    @OneToMany(fetch = FetchType.EAGER)
    Set<Vote> votes = new HashSet();
    public Long getId() {
        return id;
    }
    public Poll(){

    }
    public Poll(Date dateEnding, User userCreated,String description) {
        this.dateEnding = dateEnding;
        this.userCreated = userCreated;
        this.description = description;
        this.dateCreated = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Place> getPlaces() {
        return places;
    }

    public void setPlaces(Set<Place> places) {
        this.places = places;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateEnding() {
        return dateEnding;
    }

    public void setDateEnding(Date dateEnding) {
        this.dateEnding = dateEnding;
    }

    public User getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(User userCreated) {
        this.userCreated = userCreated;
    }

    public Set<Vote> getVotes() {
        return votes;
    }

    public void setVotes(Set<Vote> votes) {
        this.votes = votes;
    }
}
