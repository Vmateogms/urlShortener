package urlshortener.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Link")
public class Link {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private String identificationCode;
	@Column(nullable = false)
	private String originalUrl;
	@Column(nullable = false)
	private LocalDate creationDate;
	
	
	public Link(String identificationCode, String originalUrl, LocalDate creationDate) {
		 this.identificationCode = identificationCode;
		 this.originalUrl = originalUrl;
		 this.creationDate = creationDate;
	}
	
	//hibernate
	protected Link() {
		
	}


	public String getIdentificationCode() {
		return identificationCode;
	}


	public void setIdentificationCode(String  identificationCode) {
		this.identificationCode = identificationCode;
	}


	public String getOriginalUrl() {
		return originalUrl;
	}


	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}


	public LocalDate getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	
	
	
	
	
	
	
	
	
}
