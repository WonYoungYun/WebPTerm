package kr.ac.springboot.term.qna;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface QnARepository extends CrudRepository<QnA, Long>{
	List<QnA> findAllByOrderByRegdateDesc();
}
