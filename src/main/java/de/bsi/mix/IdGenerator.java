package de.bsi.mix;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;
import java.util.UUID;

@Component
public class IdGenerator {
	
	private Integer prefix;

	@PostConstruct
	private void initPrefixAfterConstruction() {
		this.prefix = new Random().nextInt(100);
	}
	
	public String generateId() {
		String uuid = UUID.randomUUID().toString();
		return String.format("%d_%s", this.prefix, uuid);
	}

}
