package mihajlo.exampleantony.it.entity;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Place place;
    private int value;

    public Rating() {
    }

    public Rating(User user, Place place, int value) {
        if(value>5){
            this.value = 5;
            return;
        }
        else if(value < 0){
            this.value = 0;
            return;
        }else{
            this.value = value;
        }
        this.user = user;
        this.place = place;
        this.value = value;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if(value>5){
            this.value = 5;
            return;
        }
        else if(value < 0){
            this.value = 0;
            return;
        }else{
            this.value = value;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
