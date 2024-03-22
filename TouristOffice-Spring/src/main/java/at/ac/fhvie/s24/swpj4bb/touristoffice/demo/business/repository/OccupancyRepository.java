package at.ac.fhvie.s24.swpj4bb.touristoffice.demo.business.repository;

import at.ac.fhvie.s24.swpj4bb.touristoffice.demo.business.entity.Hotel;
import at.ac.fhvie.s24.swpj4bb.touristoffice.demo.business.entity.Occupancy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface OccupancyRepository  extends PagingAndSortingRepository<Occupancy, Integer> {
    List<Occupancy> findAllByOrderByIdAsc();
    @Query(value = "SELECT o FROM Occupancy o ORDER BY id")
    Page<Occupancy> findAll(Pageable pageable);
    List<Occupancy> findAllById(int id, Pageable pageable);
}
