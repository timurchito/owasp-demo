package com.epam.teemo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.teemo.entity.Confidential;
import com.epam.teemo.service.ConfidentialService;


@Controller
public class InjectionController
{
	@Autowired
	private ConfidentialService confidentialService;

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name = "name",
			required = false,
			defaultValue = "World") String name, Model model)
	{
		model.addAttribute("name", name);
		return "greeting";
	}

	@GetMapping("/form")
	public String form()
	{
		return "form";
	}

	@GetMapping("/confidential")
	public String confidential(@RequestParam(name = "id",
			required = true) String id, Model model)
	{
		List<Confidential> confidentialList = confidentialService.findById(id);
		model.addAttribute("confidentialList", confidentialList);
		return "confidential";
	}

	@GetMapping("/confidential_injected")
	public String confidentialInjection(@RequestParam(name = "id",
			required = true) String id, Model model)
	{
		List<Confidential> confidentialList = confidentialService.findWithInjection(id);
		model.addAttribute("confidentialList", confidentialList);
		return "confidential";
	}

}
