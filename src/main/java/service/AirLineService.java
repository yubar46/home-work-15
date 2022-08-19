package service;

import domain.AirLine;

public interface AirLineService extends BaseService<AirLine,Integer> {

  AirLine findByeAirLineName(String airLineName);
}
