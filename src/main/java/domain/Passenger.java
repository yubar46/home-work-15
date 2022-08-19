package domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Passenger implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  @ManyToOne
  private Fly fly;



  public Passenger() {
  }

  public Passenger(String firstName, String lastName, String phoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
  public Fly getFly() {
    return fly;
  }

  public void setFly(Fly fly) {
    this.fly = fly;
  }
}
