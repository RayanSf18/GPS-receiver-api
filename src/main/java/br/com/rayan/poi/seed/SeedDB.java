package br.com.rayan.poi.seed;

import br.com.rayan.poi.domain.pointofinterest.PointOfInterest;
import br.com.rayan.poi.repository.PointOfInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class SeedDB implements CommandLineRunner {

  @Autowired
  private PointOfInterestRepository repository;

  @Override
  public void run(String... args) throws Exception {

    ArrayList<PointOfInterest> list = new ArrayList<>();
    list.add(new PointOfInterest("Lanchonete", 27L, 12L));
    list.add(new PointOfInterest("Posto", 31L, 18L));
    list.add(new PointOfInterest("Joalheria", 15L, 12L));
    list.add(new PointOfInterest("Floricultura", 19L, 21L));
    list.add(new PointOfInterest("Pub", 12L, 8L));
    list.add(new PointOfInterest("Supermercado", 23L, 6L));
    list.add(new PointOfInterest("Churrascaria", 28L, 2L));

    this.repository.saveAll(list);
  }
}
