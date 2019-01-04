package br.com.gustavoamaro.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "guest")
@NoArgsConstructor(access=AccessLevel.PRIVATE)
@ToString
public class Guest {

    @Id
    @GeneratedValue
    private @Getter Long id;

    private @Getter String name;
    private @Getter @Setter String mail;
    private @Getter @Setter String phone;

    public Guest(String name, String mail, String phone) {
		this.name = name;
		this.mail = mail;
		this.phone = phone;
	}
}