package repository;

import domain.AirLine;

import javax.persistence.EntityManager;

public class AirlineRepositoryImpl extends BaseRepositoryImpl<AirLine,Integer> implements AirlineRepository {
  public AirlineRepositoryImpl(EntityManager entityManager) {
    super(entityManager);
  }

  @Override
  Class<AirLine> getClassObject() {
    return AirLine.class;
  }
}
