package com.epam.teemo.service;

import java.util.List;

import com.epam.teemo.entity.Confidential;


public interface ConfidentialService
{
	List<Confidential> findById(String id);

	List<Confidential> findWithInjection(String id);

	void save(Confidential confidential);
}
