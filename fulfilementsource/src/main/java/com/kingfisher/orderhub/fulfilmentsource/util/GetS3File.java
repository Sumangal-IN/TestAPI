package com.kingfisher.orderhub.fulfilmentsource.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.kingfisher.orderhub.fulfilmentsource.exception.CustomExceptionHandler;
import com.kingfisher.orderhub.fulfilmentsource.exception.S3ServiceIOException;

public class GetS3File {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CustomExceptionHandler.class);

	public static String getS3FileData(String clientRegion, String bucketName,
			String fileName, String accessKey, String secret)
			throws S3ServiceIOException {
		String data = null;
		S3Object fullObject = null, objectPortion = null, headerOverrideObject = null;
		try {
			BasicAWSCredentials awsCreds = new BasicAWSCredentials(Base64
					.getDecoder().decode(accessKey).toString(), Base64
					.getDecoder().decode(secret).toString());
			AmazonS3 s3Client = AmazonS3ClientBuilder
					.standard()
					.withRegion(clientRegion)
					.withCredentials(new AWSStaticCredentialsProvider(awsCreds))
					.build();
			fullObject = s3Client.getObject(new GetObjectRequest(bucketName,
					fileName));
			try {
				data = getData(fullObject.getObjectContent());
			} catch (IOException e) {
				LOGGER.error(e.getLocalizedMessage());
				e.printStackTrace();
				throw new S3ServiceIOException(e.getLocalizedMessage());
			}

		} catch (AmazonServiceException e) {
			LOGGER.error(e.getLocalizedMessage());
			e.printStackTrace();
			throw new S3ServiceIOException(e.getLocalizedMessage());
		} catch (SdkClientException e) {
			LOGGER.error(e.getLocalizedMessage());
			e.printStackTrace();
			throw new S3ServiceIOException(e.getLocalizedMessage());
		} finally {
			if (fullObject != null) {
				try {
					fullObject.close();
				} catch (IOException e) {
					LOGGER.error(e.getLocalizedMessage());
					e.printStackTrace();
					throw new S3ServiceIOException(e.getLocalizedMessage());
				}
			}
			if (objectPortion != null) {
				try {
					objectPortion.close();
				} catch (IOException e) {
					LOGGER.error(e.getLocalizedMessage());
					e.printStackTrace();
					throw new S3ServiceIOException(e.getLocalizedMessage());
				}
			}
			if (headerOverrideObject != null) {
				try {
					headerOverrideObject.close();
				} catch (IOException e) {
					LOGGER.error(e.getLocalizedMessage());
					e.printStackTrace();
					throw new S3ServiceIOException(e.getLocalizedMessage());
				}
			}
		}
		return data;
	}

	public static String reliable() throws S3ServiceIOException {
		throw new S3ServiceIOException("Delay in S3 service");
	}

	private static String getData(InputStream input) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		String line = null;
		String data = "";
		while ((line = reader.readLine()) != null) {
			data += line;
		}
		return data;
	}
}
