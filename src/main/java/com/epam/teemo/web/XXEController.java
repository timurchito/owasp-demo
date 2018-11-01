package com.epam.teemo.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.teemo.entity.Book;


@Controller("/rest/books")
public class XXEController
{

	static final Map<Integer, Book> books = new ConcurrentHashMap<>();
	private static AtomicInteger currentId = new AtomicInteger(0);

	static {
		Book book = new Book();
		book.setId(currentId.get());
		book.setTitle("Java puzzlers");
		book.setAuthor("Joshua Bloch");
		book.setIsbn("032133678X");
		books.put(currentId.incrementAndGet(), book);
		book = new Book();
		book.setId(currentId.get());
		book.setTitle("Java concurrency in practice");
		book.setAuthor("Brian Goetz");
		book.setIsbn("0321349601");
		books.put(currentId.incrementAndGet(), book);
	}

	@PutMapping(consumes = MediaType.APPLICATION_XML_VALUE)
	public void createBook(@RequestBody Book book) {
		book.setId(currentId.incrementAndGet());
		books.put(book.getId(), book);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public List<Book> retrieveAllBooks() {
		List<Book> result = new ArrayList<>();
		for (Map.Entry<Integer, Book> entry : books.entrySet()) {
			result.add(entry.getValue());
		}
		return result;
	}

	@RequestMapping(method = RequestMethod.GET, params = "id", produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public Book retrieveBook(@RequestParam("id") int id) {
		return books.get(id);
	}

	@RequestMapping(method = RequestMethod.DELETE, params = "id")
	public void deleteBook(@RequestParam("id") int id) {
		books.remove(id);
	}

}