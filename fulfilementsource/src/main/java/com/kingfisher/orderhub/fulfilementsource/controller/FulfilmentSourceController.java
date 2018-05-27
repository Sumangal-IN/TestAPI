package com.kingfisher.orderhub.fulfilementsource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kingfisher.orderhub.fulfilementsource.service.FulfilmentSourceService;
import com.kingfisher.orderhub.fulfilmentsource.domain.FulfilmentSource;
import com.kingfisher.orderhub.fulfilmentsource.domain.Product;

@RestController
public class FulfilmentSourceController {
	@Autowired
	FulfilmentSourceService fulfilmentSourceService;

	@RequestMapping(value = "/getFulfilementSources", method = RequestMethod.POST)
	public FulfilmentSource[] getFulfilementSources(@RequestBody Product product) {
		return fulfilmentSourceService.getFulfilementSource(product);
	}
}