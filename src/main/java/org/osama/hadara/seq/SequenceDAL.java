package org.osama.hadara.seq;


import org.osama.hadara.seq.exception.SequenceException;
import org.osama.hadara.seq.model.SequenceId;

public interface SequenceDAL {

	long getNextSequenceId(String key) throws SequenceException;
	void save(SequenceId sequenceId);
	void deleteSequence();

}