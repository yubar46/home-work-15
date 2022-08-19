package service;

import domain.Fly;

import java.time.LocalDate;
import java.util.List;

public interface FlyService extends BaseService<Fly,Integer> {

  List<Fly> findByDateAndCity(LocalDate date, String SourceCity, String DesCity);
}
