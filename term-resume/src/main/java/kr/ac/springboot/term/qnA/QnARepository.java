package kr.ac.springboot.term.qnA;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface QnARepository extends CrudRepository<QnA, Long>{
	List<QnA> findAllByOrderByRegdateDesc();
}
