package context;

import domain.AirLine;
import repository.*;
import service.*;
import util.HibernateUtil;

import javax.persistence.EntityManager;

public class ApplicationContext {

  public static ApplicationContext Instance = new ApplicationContext();
  private EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
  private PassengerRepository passengerRepository = new PassengerRepositoryImpl(entityManager);
  private FlyRepository flyRepository = new FlyRepositoryImpl(entityManager);
  private BankCardRepository bankCardRepository = new BankCardRepositoryImpl(entityManager);
  private AirlineRepository airlineRepository = new AirlineRepositoryImpl(entityManager);
  private PassengerService passengerService = new PassengerServiceImpl(passengerRepository);
  private FlyService flyService = new FlyServiceImpl(flyRepository);
  private AirLineService airLineService = new AirLineServiceImpl(airlineRepository);
  private BankCardService bankCardService = new BankCardServiceImpl(bankCardRepository);

  public AirLine getAirLine() {
    return airLine;
  }

  public void setAirLine(AirLine airLine) {
    this.airLine = airLine;
  }

  private AirLine airLine;

  public static ApplicationContext getInstance() {
    return Instance;
  }

  public static void setInstance(ApplicationContext instance) {
    ApplicationContext.Instance = instance;
  }

  public PassengerRepository getPassengerRepository() {
    return passengerRepository;
  }

  public void setPassengerRepository(PassengerRepository passengerRepository) {
    this.passengerRepository = passengerRepository;
  }

  public FlyRepository getFlyRepository() {
    return flyRepository;
  }

  public void setFlyRepository(FlyRepository flyRepository) {
    this.flyRepository = flyRepository;
  }

  public AirlineRepository getAirlineRepository() {
    return airlineRepository;
  }

  public void setAirlineRepository(AirlineRepository airlineRepository) {
    this.airlineRepository = airlineRepository;
  }

  public PassengerService getPassengerService() {
    return passengerService;
  }

  public void setPassengerService(PassengerService passengerService) {
    this.passengerService = passengerService;
  }

  public FlyService getFlyService() {
    return flyService;
  }

  public void setFlyService(FlyService flyService) {
    this.flyService = flyService;
  }

  public AirLineService getAirLineService() {
    return airLineService;
  }

  public void setAirLineService(AirLineService airLineService) {
    this.airLineService = airLineService;
  }

  public BankCardRepository getBankCardRepository() {
    return bankCardRepository;
  }

  public void setBankCardRepository(BankCardRepository bankCardRepository) {
    this.bankCardRepository = bankCardRepository;
  }

  public BankCardService getBankCardService() {
    return bankCardService;
  }

  public void setBankCardService(BankCardService bankCardService) {
    this.bankCardService = bankCardService;
  }

  private ApplicationContext() {

  }


  public EntityManager getEntityManager() {
    return entityManager;
  }

  public void setEntityManager(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

}
