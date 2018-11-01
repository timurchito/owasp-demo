package com.epam.teemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epam.teemo.dao.ConfidentialDao;
import com.epam.teemo.entity.Confidential;
import com.epam.teemo.service.ConfidentialService;


@Service
public class ConfidentialServiceImpl implements ConfidentialService
{
	@Autowired
	@Qualifier("normal")
	private ConfidentialDao confidentialDao;

	@Autowired
	@Qualifier("injection")
	private ConfidentialDao injectionConfidentialDao;

	@Override
	public List<Confidential> findById(String id)
	{
		return confidentialDao.find(id);
	}

	@Override
	public List<Confidential> findWithInjection(String id)
	{
		return injectionConfidentialDao.find(id);
	}

	@Override
	public void save(Confidential confidential)
	{
		System.out.println("Confidential object successfully saved!");
	}
}
