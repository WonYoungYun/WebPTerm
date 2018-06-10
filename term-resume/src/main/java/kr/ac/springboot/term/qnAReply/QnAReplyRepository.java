package kr.ac.springboot.term.qnAReply;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import kr.ac.springboot.term.qnA.QnA;


public interface QnAReplyRepository extends CrudRepository<QnAReply, Long>{
	List<QnAReply> findAllByQnaOrderByUpdatedateDesc(QnA qna);
}
