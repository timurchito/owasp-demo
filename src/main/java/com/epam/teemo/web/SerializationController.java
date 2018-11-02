package com.epam.teemo.web;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.teemo.entity.Confidential;
import com.epam.teemo.service.ConfidentialService;


@Controller()
public class SerializationController
{

	@Autowired
	private ConfidentialService confidentialService;

	@RequestMapping(value = "/serialization", params = "confId", method = RequestMethod.GET)
	public @ResponseBody
	byte[] serialize(@RequestParam("confId") String confId) throws IOException
	{
		Confidential confidential = confidentialService.findById(confId).get(0);
		return SerializationUtils.serialize(confidential);
//		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//		ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
//		outputStream.writeObject(confidential);
//		outputStream.flush();
//		return byteArrayOutputStream.toByteArray();
	}

	@RequestMapping(value = "/serialization", method = RequestMethod.POST)
	public void deserialize(@RequestBody byte[] input) throws IOException, ClassNotFoundException
	{
		Confidential confidential = (Confidential) SerializationUtils.deserialize(input);
//		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input);
//		ObjectInputStream objectInputStream =  new ObjectInputStream(byteArrayInputStream);
//		Confidential confidential = (Confidential) objectInputStream.readObject();
		confidentialService.save(confidential);
	}


}
