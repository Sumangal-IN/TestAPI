package com.kingfisher.orderhub.fulfilmentsource.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.kingfisher.orderhub.fulfilmentsource.domain.FulfilmentSource;
import com.kingfisher.orderhub.fulfilmentsource.domain.Product;

public class GenerateFile {

	public static void main(String args[]) throws JsonIOException, IOException {

		Map<String, FulfilmentSource[]> map = new HashMap<String, FulfilmentSource[]>();

		FulfilmentSource fs1 = new FulfilmentSource("FC1", "FC",
				"FC_home_delivery");
		FulfilmentSource fs2 = new FulfilmentSource("FC2", "FC",
				"FC_click&collect");
		FulfilmentSource fs3 = new FulfilmentSource("FC3", "FC",
				"FC_Store_Delivery");
		FulfilmentSource fs4 = new FulfilmentSource("DSV1", "DSV",
				"DSV_home_delivery");
		FulfilmentSource fs5 = new FulfilmentSource("DSV2", "DSV",
				"DSV_click&collect");
		FulfilmentSource fs6 = new FulfilmentSource("DSV3", "DSV",
				"DSV_Store_Delivery");
		FulfilmentSource fs7 = new FulfilmentSource("screwfix1", "screwfix",
				"screwfix_home_delivery");
		FulfilmentSource fs8 = new FulfilmentSource("screwfix2", "screwfix",
				"screwfix_click&collect");
		FulfilmentSource fs9 = new FulfilmentSource("screwfix3", "screwfix",
				"screwfix_Store_Delivery");

		Product p1 = new Product("10141", "Product 1", "101");
		Product p2 = new Product("10142", "Product 2", "540");
		Product p3 = new Product("10143", "Product 3", "169");

		FulfilmentSource[] fc1 = { fs1, fs2, fs5 };
		FulfilmentSource[] fc2 = { fs3, fs4, fs5, fs7 };
		FulfilmentSource[] fc3 = { fs8, fs9, fs6, fs1 };

		map.put(p1.getProduct_id(), fc1);
		map.put(p2.getProduct_id(), fc2);
		map.put(p3.getProduct_id(), fc3);

		Gson gson = new Gson();

		gson.toJson(map, new FileWriter("C:\\downloads\\file.json"));
		System.out.println(gson.toJson(map));

	}

}