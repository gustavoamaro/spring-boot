package br.com.gustavoamaro.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.gustavoamaro.springboot.service.GuestService;
import br.com.gustavoamaro.springboot.service.MailService;

@Controller
public class GuestController {

	@Autowired
	private transient GuestService guestService;

	@Autowired
	private transient MailService mailService;

	@RequestMapping("/")
    public String index(){
        return "index";
    }

	@RequestMapping("guestslist")
	public String guestsList(Model model){
	    model.addAttribute("guests", guestService.findAll());
	    return "guestslist";
	}

	@RequestMapping(value= "invite", method = RequestMethod.POST)
	public String invite(Model model,
			@RequestParam("name") String name,
			@RequestParam("mail") String mail,
            @RequestParam("phone") String phone){

		guestService.save(name, mail, phone);
		mailService.send(name, mail);
		return guestsList(model);
	}

	@RequestMapping(value= "delete", method = RequestMethod.POST)
	public String delete(Model model, @RequestParam("id") String id){
		guestService.delete(Long.parseLong(id));
		return guestsList(model);
	}
}