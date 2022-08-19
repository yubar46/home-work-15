package service;

import domain.Fly;
import repository.FlyRepository;

import java.time.LocalDate;
import java.util.List;

public class FlyServiceImpl extends BaseServiceImpl<Fly,Integer, FlyRepository> implements FlyService {
  public FlyServiceImpl(FlyRepository repository) {
    super(repository);
  }

  @Override
  public List findByDateAndCity(LocalDate date, String SourceCity, String DesCity) {
    return repository.getEntityManager().createQuery
      ("select f from Fly as f where f.flyDate= :flyDate and f.sourceCity= :soruceCity and f.destinationCity= :desCity")
      .setParameter("soruceCity",SourceCity).setParameter("desCity",DesCity).setParameter("flyDate",date).getResultList();
  }
}
