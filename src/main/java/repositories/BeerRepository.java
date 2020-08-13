package repositories;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import domain.Beer;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID>{

}
