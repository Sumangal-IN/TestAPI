package com.kingfisher.orderhub.fulfilmentsource.domain;

public class FulfilmentSource {

	private String source_id;
	private String source_type;
	private String source_name;

	public FulfilmentSource() {

	}

	public FulfilmentSource(String source_id, String source_type,
			String source_name) {
		super();
		this.source_id = source_id;
		this.source_type = source_type;
		this.source_name = source_name;
	}

	public String getSource_id() {
		return source_id;
	}

	public void setSource_id(String source_id) {
		this.source_id = source_id;
	}

	public String getSource_type() {
		return source_type;
	}

	public void setSource_type(String source_type) {
		this.source_type = source_type;
	}

	public String getSource_name() {
		return source_name;
	}

	public void setSource_name(String source_name) {
		this.source_name = source_name;
	}
}