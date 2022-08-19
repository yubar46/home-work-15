package service;

import domain.Passenger;
import repository.PassengerRepository;

public class PassengerServiceImpl extends BaseServiceImpl<Passenger,Integer, PassengerRepository> implements PassengerService {
  public PassengerServiceImpl(PassengerRepository repository) {
    super(repository);
  }
}
