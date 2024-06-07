package br.com.rayan.poi.domain.pointofinterest;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_points_of_interest")
public class PointOfInterest {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private Long x;

  private Long y;

  public PointOfInterest(String name, Long x, Long y) {
    this.name = name;
    this.x = x;
    this.y = y;
  }

}
