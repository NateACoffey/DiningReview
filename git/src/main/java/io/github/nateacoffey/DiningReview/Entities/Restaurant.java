package io.github.nateacoffey.DiningReview.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "RESTAURANTS")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	private Long id;
	
	@Getter @Setter
	@Column(name = "OVERALL_SCORE")
	private Integer overallScore;
	
	@Getter @Setter
	@Column(name = "PEANUT_ALLERGY")
	private Integer peanutAllergy;
	
	@Getter @Setter
	@Column(name = "EGG_ALLERGY")
	private Integer eggAllergy;
	
	@Getter @Setter
	@Column(name = "DAIRY_ALLERGY")
	private Integer dairyAllergy;
	
	
}
