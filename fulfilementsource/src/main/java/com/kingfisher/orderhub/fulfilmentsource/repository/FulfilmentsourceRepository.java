package com.kingfisher.orderhub.fulfilmentsource.repository;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kingfisher.orderhub.fulfilmentsource.domain.FulfilmentSource;
import com.kingfisher.orderhub.fulfilmentsource.domain.Product;
import com.kingfisher.orderhub.fulfilmentsource.exception.NoFulfilementSourceExistsException;
import com.kingfisher.orderhub.fulfilmentsource.util.GetS3File;

@Repository
public class FulfilmentsourceRepository {
	@Value("${aws.S3.region}")
	private String region;

	@Value("${aws.S3.bucketName}")
	private String bucketName;

	@Value("${aws.S3.accessKey}")
	private String accessKey;

	@Value("${aws.s3.secret}")
	private String secret;

	@Value("${repository.product-fs}")
	private String fileName;

	public FulfilmentSource[] getFulfilmentSource(Product product) {
		String JSON = GetS3File.getS3FileData(region, bucketName, fileName,
				accessKey, secret);
		Gson gson = new Gson();
		final Type REVIEW_TYPE = new TypeToken<HashMap<String, FulfilmentSource[]>>() {
		}.getType();
		Map<String, FulfilmentSource[]> product_map_fs = gson.fromJson(JSON,
				REVIEW_TYPE);
		FulfilmentSource[] fulfilmentSources = product_map_fs.get(product
				.getProduct_id());
		if (fulfilmentSources == null)
			throw new NoFulfilementSourceExistsException(
					"No Fulfilment Souce exists for Product ID "
							+ product.getProduct_id());
		return fulfilmentSources;
	}
}
