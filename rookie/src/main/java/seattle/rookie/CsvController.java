package seattle.rookie;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import seattle.rookie.model.Result;
import seattle.rookie.repositories.ResultRepository;

@RestController
public class CsvController {

	@Autowired
	ResultRepository resultRepository;

	@Autowired
	CsvService csv;

	// データをCSV出力するメソッド
	@RequestMapping(value = "/csv/{year}/{term}")
	public void getCsv(HttpServletResponse response, @PathVariable("year") int year, @PathVariable boolean term)
			throws JsonProcessingException {
		List<Result> resultsList = resultRepository.findByYearAndTerm(year, term);
		csv.outputCsv(response, resultsList);
	}

}
