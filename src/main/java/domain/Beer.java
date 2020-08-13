package domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Beer {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID",strategy ="org.hibernate.id.UUIDGenerator")
	@Column(length = 36,columnDefinition = "varchar",updatable = false,nullable = false)
	private UUID Id;
	@Version
	private Long version;
	
	@CreationTimestamp
	@Column(updatable = false)
	private Timestamp createdDate;
	@UpdateTimestamp
	private Timestamp lastModifiedDate;
	private String beerName;
	private String beerStyle;
	@Column(unique = true)
	private Long upc;
	private BigDecimal price;
	
	private Integer minOnHand;
	private Integer quantityToBrew;
	
	

}
