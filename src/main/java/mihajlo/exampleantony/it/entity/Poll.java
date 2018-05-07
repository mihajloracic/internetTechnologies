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
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "poll_user",
            joinColumns = { @JoinColumn(name = "poll_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") })
    Set<User> users = new HashSet<>();
    @ManyToMany(fetch = FetchType.LAZY)
    Set<Place> places = new HashSet<>();
    @JsonIgnore
    Date dateCreated;
    Date dateEnding;
    @ManyToOne
    User userCreated;
    String description;
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
}
