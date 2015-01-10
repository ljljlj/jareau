package net.yorkjr.jareau.controller;

import net.yorkjr.jareau.dao.CompanyAgentDAO;
import net.yorkjr.jareau.pojo.CompanyAgent;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import sun.management.Agent;

/**
 * Created by tylaar on 15/1/10.
 */
@Controller
@SessionAttributes
@RequestMapping("/agent")
public class AgentController {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @RequestMapping(value = "getAgent/{agentId}", method = RequestMethod.POST)
    public String getAgentInformation(@PathVariable("agentId") long agentId, ModelMap modelMap, BindingResult result) {
        System.out.println("get agent operation hit the backend service." + agentId);
        return "agentInfo";
    }
}
