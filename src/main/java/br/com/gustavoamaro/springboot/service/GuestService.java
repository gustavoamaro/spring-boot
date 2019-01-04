package br.com.gustavoamaro.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gustavoamaro.springboot.model.Guest;
import br.com.gustavoamaro.springboot.repository.GuestRepository;

@Service
public class GuestService {

	@Autowired
	private transient GuestRepository guestRepository;

	public Iterable<Guest> findAll(){
	    return guestRepository.findAll();
	}

	public Guest save(String name, String mail, String phone){
		return guestRepository.save(new Guest(name, mail, phone));
	}

	public void delete(long id){
		guestRepository.deleteById(id);
	}
}