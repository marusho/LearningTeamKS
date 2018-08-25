package seattle.rookie.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class WebExceptionHandler {

	// @ExceptionHandler(Exception.class)
	// @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ModelAndView handleException(Exception exception, ModelAndView mav) {
		mav.setViewName("error");
		mav.addObject("message", "ページが見つかりません");
//		mav.addObject("status", HttpStatus.INTERNAL_SERVER_ERROR);
		
		return mav;
	}

}
