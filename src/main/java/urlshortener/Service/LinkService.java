package urlshortener.Service;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;

import urlshortener.Repository.LinkRepository;
import urlshortener.entities.Link;

@Service
public class LinkService {
	private final LinkRepository lRepo;
	private static final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private static final SecureRandom random = new SecureRandom(); 
	private static final int LENGTH = 7;
	
	
	
	public LinkService(LinkRepository lRepo) {
		this.lRepo = lRepo;
	}


	public Link createLink(String url) {
		
		String code = generateRandomString();
		Link var = new Link(code, url, LocalDate.now());
		lRepo.save(var);
		return var;

	}
	
	
	private String generateRandomString() {
		StringBuilder sb = new StringBuilder(LENGTH);
		for(int i = 0; i < LENGTH; i++) {
			int index = random.nextInt(ALPHANUMERIC.length());
			sb.append(ALPHANUMERIC.charAt(index)); 
		}
		return sb.toString();
		
	}
	
	public Optional<Link> searchUrlWithCode(String identificationCode) {
	return lRepo.findByIdentificationCode(identificationCode);
	}
	
	
	
}
