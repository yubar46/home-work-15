package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Fly implements Comparable<Fly> , Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Integer flyCost;
  private String airplaneModel;
  private String sourceCity;
  private String destinationCity;
  @OneToMany(mappedBy = "fly")
  List<Passenger> passengers = new ArrayList<>();
  private LocalTime flyTime;
  private LocalDate flyDate;
  @ManyToOne
  private AirLine airLine;


  public Fly() {
  }

  public Fly(Integer flyCost, String airplaneModel, String sourceCity, String destinationCity, LocalTime flyTime, LocalDate flyDate) {
    this.flyCost = flyCost;
    this.airplaneModel = airplaneModel;
    this.sourceCity = sourceCity;
    this.destinationCity = destinationCity;
    this.flyTime = flyTime;
    this.flyDate = flyDate;
  }


  public AirLine getAirLine() {
    return airLine;
  }

  public void setAirLine(AirLine airLine) {
    this.airLine = airLine;
  }

  public LocalTime getFlyTime() {
    return flyTime;
  }

  public void setFlyTime(LocalTime flyTime) {
    this.flyTime = flyTime;
  }

  public LocalDate getFlyDate() {
    return flyDate;
  }

  public void setFlyDate(LocalDate flyDate) {
    this.flyDate = flyDate;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getFlyCost() {
    return flyCost;
  }

  public void setFlyCost(Integer flyCost) {
    this.flyCost = flyCost;
  }

  public String getAirplaneModel() {
    return airplaneModel;
  }

  public void setAirplaneModel(String airplaneModel) {
    this.airplaneModel = airplaneModel;
  }

  public String getSourceCity() {
    return sourceCity;
  }

  public void setSourceCity(String sourceCity) {
    this.sourceCity = sourceCity;
  }

  public String getDestinationCity() {
    return destinationCity;
  }

  public void setDestinationCity(String destinationCity) {
    this.destinationCity = destinationCity;
  }

  public List<Passenger> getPassengers() {
    return passengers;
  }

  public void setPassengers(List<Passenger> passengers) {
    this.passengers = passengers;
  }


  @Override
  public String toString() {
    return "Fly{" +
      "id=" + id +
      ", flyCost='" + flyCost + '\'' +
      ", airplaneModel='" + airplaneModel + '\'' +
      ", sourceCity='" + sourceCity + '\'' +
      ", destinationCity='" + destinationCity + '\'' +
      ", flyTime=" + flyTime +
      ", flyDate=" + flyDate +
      ", airLine=" + airLine.getName() +
      '}';
  }

  public int compareToFlyCost(Fly o) {
    return this.flyCost.compareTo(o.flyCost);
  }

  public int compareToSourceCity(Fly o) {
    return this.sourceCity.compareTo(o.sourceCity);
  }
  public int compareToDesCity(Fly o) {
    return this.destinationCity.compareTo(o.destinationCity);
  }
  public int compareToAirlineCompany(Fly o) {
    return this.airLine.getName().compareTo(o.airLine.getName());
  }

  @Override
  public int compareTo(Fly o) {
    return 0;
  }
}
