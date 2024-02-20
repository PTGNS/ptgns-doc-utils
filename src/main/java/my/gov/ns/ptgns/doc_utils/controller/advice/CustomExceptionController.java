package my.gov.ns.ptgns.doc_utils.controller.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URL;

@ControllerAdvice
public class CustomExceptionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionController.class);
    //private AppResponse appResponse;

    @ExceptionHandler(Exception.class)
    public String handleError(Model model, HttpServletRequest request, Exception ex) throws MalformedURLException {
        LOGGER.error("Request: {} | Error: {}", request.getRequestURL(), ex.getMessage());
        //If the request coming from client's browser
        String clientBrowserHostname = request.getRemoteHost();
        LOGGER.error("clientBrowserHostname: {}", clientBrowserHostname);
        //If request coming from client's server
        String serverDomainName = new URL(request.getRequestURL().toString()).getHost();
        LOGGER.error("serverDomainName: {}", serverDomainName);
        model.addAttribute("error", ex.getMessage());
        ex.printStackTrace();
        return "exception/handler";
    }
}
