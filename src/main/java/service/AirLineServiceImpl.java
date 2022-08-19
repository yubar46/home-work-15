package service;

import domain.AirLine;
import repository.AirlineRepository;

import java.util.List;

public class AirLineServiceImpl extends BaseServiceImpl<AirLine,Integer, AirlineRepository> implements AirLineService {
  public AirLineServiceImpl(AirlineRepository repository) {
    super(repository);
  }

  @Override
  public AirLine findByeAirLineName(String airLineName) {
    List<AirLine> airlines = repository.getEntityManager().createQuery("select a from AirLine a where a.name= :name",AirLine.class)
      .setParameter("name", airLineName).getResultList();
    if (!airlines.isEmpty())return airlines.get(0);
    else return null;

  }
}
