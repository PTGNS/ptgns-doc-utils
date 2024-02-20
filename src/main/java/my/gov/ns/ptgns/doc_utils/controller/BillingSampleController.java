package my.gov.ns.ptgns.doc_utils.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.io.IOException;
import java.text.SimpleDateFormat;

@RestController
public class BillingSampleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BillingSampleController.class);

    @Autowired
    private Environment env;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/bills/sample", method = RequestMethod.GET)
    public ModelAndView billingSample() throws IOException {
        ModelAndView mav = new ModelAndView("billingSample");
        return mav;
    }
}
