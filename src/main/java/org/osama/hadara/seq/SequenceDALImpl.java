package org.osama.hadara.seq;


import org.osama.hadara.seq.SequenceDAL;
import org.osama.hadara.seq.exception.SequenceException;
import org.osama.hadara.seq.model.SequenceId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class SequenceDALImpl implements SequenceDAL {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public long getNextSequenceId(String key) throws SequenceException {

		Query query = new Query(Criteria.where("_id").is(key));

		Update update = new Update();
		update.inc("seq", 1);

		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);

		SequenceId seqId = mongoTemplate.findAndModify(query, update, options, SequenceId.class);

		if (seqId == null) {
			throw new SequenceException("Unable to get sequence id for key : " + key);
		}

		return seqId.getSeq();

	}

    @Override
    public void save(SequenceId sequenceId) {
        mongoTemplate.save(sequenceId);
    }

    @Override
    public void deleteSequence() {
        mongoTemplate.dropCollection(SequenceId.class);
    }

}