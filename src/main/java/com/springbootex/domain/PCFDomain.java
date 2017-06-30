package com.springbootex.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@JsonInclude(Include.NON_NULL)
@Document(collection="pcfdomain")
@ToString
public class PCFDomain {
	@Id
	private String pcfId;
	private String pcfVersion;
	
}
