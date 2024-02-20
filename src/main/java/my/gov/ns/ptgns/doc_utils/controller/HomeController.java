package my.gov.ns.ptgns.doc_utils.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private Environment env;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ServletContext servletContext;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        return "home/landing";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error(RedirectAttributes redirectAttrs) {
        Exception ex = (Exception) request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        redirectAttrs.addFlashAttribute("alert", ex.getMessage());
        redirectAttrs.addFlashAttribute("alertType", "danger");
        return "redirect:/";
    }
}
