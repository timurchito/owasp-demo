package com.epam.teemo.dao;

import java.util.List;

import com.epam.teemo.entity.Confidential;


public interface ConfidentialDao
{

	List<Confidential> find(String id);

}
