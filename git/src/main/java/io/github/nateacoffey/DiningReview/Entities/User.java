package io.github.nateacoffey.DiningReview.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USERS")
public class User {
	
	@Id
	@GeneratedValue
	@Getter
	private Long id;
	
	@Getter @Setter
	@Column(name = "DISPLAY_NAME", unique = true)
	private String displayName;
	
	@Getter @Setter
	@Column(name = "CITY")
	private String city;
	
	@Getter @Setter
	@Column(name = "STATE")
	private String state;
	
	@Getter @Setter
	@Column(name = "ZIP_CODE")
	private Integer zipCode;
	
	@Getter @Setter
	@Column(name = "PEANUT_ALLERGIES")
	private Boolean peanutAllergies;
	
	@Getter @Setter
	@Column(name = "EGG_ALLERGIES")
	private Boolean eggAllergies;
	
	@Getter @Setter
	@Column(name = "DAIRY_ALLERGIES")
	private Boolean dairyAllergies;
	
	
	
}
