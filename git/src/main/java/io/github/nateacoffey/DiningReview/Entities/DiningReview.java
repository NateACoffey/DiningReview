package io.github.nateacoffey.DiningReview.Entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DINING_REVIEWS")
public class DiningReview {
	
	@Id
	@GeneratedValue
	@Getter
	private Long id;
	
	@Getter @Setter
	@Column(name = "USERNAME")
	private String username;
	
	@Getter @Setter
	@Column(name = "RESTAURANT_ID")
	private Long restaurantId;
	
	@Getter @Setter
	@Basic(optional = true)
	@Column(name = "PEANUT_ALLERGY")
	private Integer peanutAllergy;
	
	@Getter @Setter
	@Basic(optional = true)
	@Column(name = "EGG_ALLERGY")
	private Integer eggAllergy;
	
	@Getter @Setter
	@Basic(optional = true)
	@Column(name = "DAIRY_ALLERGY")
	private Integer dairyAllergy;
	
	@Getter @Setter
	@Basic(optional = true)
	@Column(name = "COMMENTARY")
	private String commentary;
	
	
}
