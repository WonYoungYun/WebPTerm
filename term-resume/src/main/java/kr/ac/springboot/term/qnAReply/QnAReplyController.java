package kr.ac.springboot.term.qnAReply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kr.ac.springboot.term.qnA.QnA;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/replies/*")
public class QnAReplyController {
	
	@Autowired
	private QnAReplyRepository replyRepo;
	

	
	@GetMapping("/{qno}")
	public ResponseEntity<List<QnAReply>> getReplies(@PathVariable("qno") Long qno) {
		
		QnA qna = new QnA();
		qna.setQno(qno);
		return new ResponseEntity<>(getListByQna(qna), HttpStatus.OK);
	}
	
	@Transactional
	@PostMapping("/{qno}")
	public ResponseEntity<List<QnAReply>> addReply(@PathVariable("qno") Long qno, @RequestBody QnAReply reply){
		
		QnA qna = new QnA();
		qna.setQno(qno);
		
		reply.setQna(qna);
		
		replyRepo.save(reply);
		
		return new ResponseEntity<>(getListByQna(qna), HttpStatus.CREATED);
	}
	
	@Transactional
	@DeleteMapping("/{qno}/{rno}")
	public ResponseEntity<List<QnAReply>> remove(
			@PathVariable("qno") Long qno,
			@PathVariable("rno") Long rno) {
		
		replyRepo.deleteById(rno);
		
		QnA qna = new QnA();
		qna.setQno(qno);
		
		return new ResponseEntity<>(getListByQna(qna), HttpStatus.OK);
	}
	
	@Transactional
	@PutMapping("/{qno}")
	public ResponseEntity<List<QnAReply>> modify(@PathVariable("qno") Long qno, @RequestBody QnAReply reply) {
		
		replyRepo.findById(reply.getRno()).ifPresent(origin -> {
			origin.setReplyText(reply.getReplyText());
			replyRepo.save(origin);
		});
		
		QnA qna = new QnA();
		qna.setQno(qno);
		
		return new ResponseEntity<>(getListByQna(qna), HttpStatus.OK);
	}
	
	private List<QnAReply> getListByQna(QnA qna) throws RuntimeException{
		return replyRepo.findAllByQnaOrderByUpdatedateDesc(qna);
	}
	
}
