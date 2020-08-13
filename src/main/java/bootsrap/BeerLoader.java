package bootsrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import domain.Beer;
import repositories.BeerRepository;

@Component
public class BeerLoader implements CommandLineRunner{

	private final BeerRepository beerRepository; 
	
	
	public BeerLoader(BeerRepository beerRepository) {
		super();
		System.out.println("In Beer loader");
		this.beerRepository = beerRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		loadBeerObjects();
	}
	
	private void loadBeerObjects() {
		if(beerRepository.count()==0) {
			beerRepository.save(Beer.builder()
					.beerName("Mango Bobs")
					.beerStyle("IPA")
					.quantityToBrew(200)
					.minOnHand(12)
					.upc(337010000000L)
					.price(new BigDecimal("12.95"))
					.build());
			
			beerRepository.save(Beer.builder()
					.beerName("Galaxy Cat")
					.beerStyle("PALE_ALE")
					.quantityToBrew(200)
					.minOnHand(12)
					.upc(337010000000L)
					.price(new BigDecimal("11.95"))
					.build());
		}
		
		System.out.println("Loaded Beers : "+beerRepository.count());
	}

}
