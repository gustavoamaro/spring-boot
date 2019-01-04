package br.com.gustavoamaro.springboot;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.gustavoamaro.springboot.model.Guest;
import br.com.gustavoamaro.springboot.repository.GuestRepository;

@SpringBootApplication
public class Configuration {

	@Autowired
	private transient GuestRepository guestRepository;

	public static void main(String[] args) {
	    SpringApplication.run(Configuration.class, args);
	}

	@PostConstruct
	public void postContruct(){
		mockGuests();
	}

	private void mockGuests() {
		guestRepository.save(new Guest("Guest 1", "guest1@guestslist.com", "55 11 963100001"));
		guestRepository.save(new Guest("Guest 2", "guest2@guestslist.com", "55 11 963100002"));
		guestRepository.save(new Guest("Guest 3", "guest3@guestslist.com", "55 11 963100003"));
	}
}