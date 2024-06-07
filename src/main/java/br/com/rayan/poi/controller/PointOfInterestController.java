package br.com.rayan.poi.controller;

import br.com.rayan.poi.domain.pointofinterest.PointOfInterest;
import br.com.rayan.poi.domain.pointofinterest.PointOfInterestRequest;
import br.com.rayan.poi.repository.PointOfInterestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/points-of-interests")
public class PointOfInterestController {

  private final PointOfInterestRepository repository;

  @PostMapping
  public ResponseEntity<Void> registerPoi(@RequestBody PointOfInterestRequest body) {

    this.repository.save(new PointOfInterest(body.name(), body.x(), body.y()));
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public ResponseEntity<Page<PointOfInterest>> listAllPoi(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                          @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
    var list = this.repository.findAll(PageRequest.of(page, pageSize));
    return ResponseEntity.ok().body(list);
  }

  @GetMapping(path = "/near-me")
  public ResponseEntity<List<PointOfInterest>> nearMe(@RequestParam("x") Long x,
                                                      @RequestParam("y") Long y,
                                                      @RequestParam("dmax") Long dmax) {
    long xMin = x - dmax;
    long xMax = x + dmax;
    long yMin = y - dmax;
    long yMax = y + dmax;

    var list = this.repository.findNearMe(xMin, xMax, yMin, yMax)
      .stream()
      .filter(p -> distanceBetweenPoints(x, y, p.getX(), p.getY()) <= dmax)
      .toList();

    return ResponseEntity.ok().body(list);
  }

  private double distanceBetweenPoints(Long x1, Long y1, Long x2, Long y2) {
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
  }
}
