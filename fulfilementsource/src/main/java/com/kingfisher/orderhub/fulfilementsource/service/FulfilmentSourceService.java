package com.kingfisher.orderhub.fulfilementsource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kingfisher.orderhub.fulfilmentsource.domain.FulfilmentSource;
import com.kingfisher.orderhub.fulfilmentsource.domain.Product;
import com.kingfisher.orderhub.fulfilmentsource.repository.FulfilmentsourceRepository;

@Service
public class FulfilmentSourceService {

	@Autowired
	FulfilmentsourceRepository fulfilmentsourceRepository;

	public FulfilmentSource[] getFulfilementSource(Product product) {
		return fulfilmentsourceRepository.getFulfilmentSource(product);
	}
}
