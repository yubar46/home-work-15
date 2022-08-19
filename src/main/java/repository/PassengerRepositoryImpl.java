package repository;

import domain.Passenger;

import javax.persistence.EntityManager;

public class PassengerRepositoryImpl extends BaseRepositoryImpl<Passenger,Integer> implements PassengerRepository {
  public PassengerRepositoryImpl(EntityManager entityManager) {
    super(entityManager);
  }

  @Override
  Class<Passenger> getClassObject() {
    return Passenger.class;
  }
}
