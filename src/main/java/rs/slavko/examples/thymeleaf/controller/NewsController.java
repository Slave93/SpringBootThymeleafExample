package rs.slavko.examples.thymeleaf.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import rs.slavko.examples.thymeleaf.model.News;
import rs.slavko.examples.thymeleaf.repository.NewsRepository;

@Controller
@RequestMapping("/news")
public class NewsController {
	
	private static final Logger logger = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private NewsRepository newsRepository;

    @RequestMapping(value="", method=RequestMethod.GET)
    public String listnews(Model model) {
        model.addAttribute("news", newsRepository.findAll());
        return "news/list";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long id) {
        newsRepository.delete(id);
        return new ModelAndView("redirect:/news");
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String newProject() {
        return "news/new";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam("message") String comment,@RequestParam("author") String author) {
        newsRepository.save(new News(comment, new Date(), author));
        return new ModelAndView("redirect:/news");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam("news_id") long id,
                               @RequestParam("message") String message) {
        News news = newsRepository.findOne(id);
        news.setMessage(message);
        newsRepository.save(news);
        return new ModelAndView("redirect:/news");
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable long id,
                       Model model) {
        News news = newsRepository.findOne(id);
        model.addAttribute("news", news);
        return "news/edit";
    }


}
