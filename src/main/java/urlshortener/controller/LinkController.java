package urlshortener.controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import urlshortener.Records.CodeRecord;
import urlshortener.Records.UrlRecord;
import urlshortener.Service.LinkService;
import urlshortener.entities.Link;

@RestController
@RequestMapping()
public class LinkController {
	
	private final LinkService linkService;
	
	
	
	public LinkController(LinkService linkService) {
		this.linkService = linkService;
	}



	@PostMapping("/linkShortened")
	public ResponseEntity<CodeRecord> linkShortened(@RequestBody UrlRecord url){
		Link link = linkService.createLink(url.url());
		CodeRecord crd = new CodeRecord(link.getIdentificationCode());
		return ResponseEntity.status(HttpStatus.CREATED).body(crd);
	}
	
	@GetMapping("/{identificationCode}")
	public ResponseEntity<Void> redirect(@PathVariable String identificationCode){
		
		Optional<Link> link = linkService.searchUrlWithCode(identificationCode);
		if(link.isPresent()) {
			return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(link.get().getOriginalUrl())).build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		
	}
	
	
	
}
