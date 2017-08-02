package son.duong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import son.duong.dao.FeedbackDao;
import son.duong.entities.Feedback;

@Controller
public class IndexController {

	@Autowired
	FeedbackDao fdao;

	Feedback feedback;

	@RequestMapping("/")
	public String home() {
		return "question";
	}

	@RequestMapping("/feedback.htm")
	public String feedback() {
		return "feedback";
	}

	@RequestMapping("/addFeedback")
	// public String addFeedback(@RequestParam("name") String name,
	// @RequestParam("email") String email, @RequestParam("msg") String message,
	// @RequestParam("reg") String regarding, @RequestParam("code") String code,
	// @RequestParam("rating") int rating){
	public String addFeedback(@ModelAttribute("feedback") Feedback feedback) {
		// feedback = new Feedback(name, email, regarding, message, code,
		// rating);
		fdao.addFeedback(feedback);
		return "index";
	}

	@RequestMapping("/getFeedbacks")
	public ModelAndView getFeedbacks() {
		ModelAndView mv = new ModelAndView("feedbacks");

		mv.addObject("feedbacks", fdao.getFeedbacks());

		return mv;
	}
	
	@RequestMapping("/get2Feedbacks")
	@ResponseBody
	public String get2Feedbacks() {
		List<Feedback> feedbacks = fdao.get2Feedbacks();

		return feedbacks.toString();
	}
}
