package com.springbootex.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.springbootex.domain.PCFDomain;

@Repository
public class PCFRepository {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public PCFDomain findOne(String pcfId) {
		return mongoTemplate.findOne(new Query(new Criteria().where("_id").is(pcfId)),PCFDomain.class);
	}

	public String save(PCFDomain pcfDomain) {
		mongoTemplate.save(pcfDomain, "pcfdomain");
		return "customer added successfully";
	}
}


/*public interface PCFRepository extends MongoRepository<PCFDomain,String> {

	//@Query("{pcfId:1}")
	public PCFDomain findOne(String pcfId);
	public PCFDomain findOne(String pcfId) {
		PCFDomain pcfDomain = new PCFDomain();
		return pcfDomain;
	}
	
	public PCFDomain save(PCFDomain pcfDomain);

}
*/