package com.epam.teemo.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ChatController
{

	private static List<Comment> comments = new ArrayList<>();

	static {
		Comment c = new Comment();
		c.setText("First cool comment");
		comments.add(c);
		c = new Comment();
		c.setText("Second cool comment");
		comments.add(c);
		c = new Comment();
		c.setText("Third cool comment");
		comments.add(c);
	}

	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public String getChatPage(Model model) {
		model.addAttribute("commentList", comments);
		return "chat";
	}

	@RequestMapping(value = "/post_chat", method = RequestMethod.POST)
	public String postComment(@ModelAttribute Comment comment, Model model) {
		comments.add(comment);
		model.addAttribute("commentList", comments);
		return "chat";
	}

}

class Comment {

	private String text;

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}
}
