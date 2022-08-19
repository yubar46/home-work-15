package repository;

import domain.Fly;

import javax.persistence.EntityManager;

public class FlyRepositoryImpl extends BaseRepositoryImpl<Fly,Integer> implements FlyRepository {
  public FlyRepositoryImpl(EntityManager entityManager) {
    super(entityManager);
  }

  @Override
  Class<Fly> getClassObject() {
    return Fly.class;
  }
}
