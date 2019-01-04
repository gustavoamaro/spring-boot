package br.com.gustavoamaro.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.gustavoamaro.springboot.model.Guest;

public interface GuestRepository extends CrudRepository<Guest, Long>{

}