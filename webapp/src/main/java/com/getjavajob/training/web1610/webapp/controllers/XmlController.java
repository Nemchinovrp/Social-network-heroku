package com.getjavajob.training.web1610.webapp.controllers;

import com.getjavajob.training.web1610.common.Account;
import com.getjavajob.training.web1610.service.AccountService;
import com.getjavajob.training.web1610.service.exception.ServiceException;
import com.thoughtworks.xstream.XStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class XmlController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private XStream xstream;

    @RequestMapping(value = "exportXml", method = RequestMethod.GET)
    public HttpEntity<byte[]> exportToXml(HttpSession session) throws IOException {
        Account account = (Account) session.getAttribute("account");
        xstream.processAnnotations(Account.class);
        byte[] bytes = xstream.toXML(account).getBytes("UTF-8");
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "xml"));
        header.setContentLength(bytes.length);
        header.set("Content-Disposition", "attachment; filename=account.xml");
        return new HttpEntity<>(bytes, header);
    }

    @RequestMapping(value = "importXml")
    public String redirectPageImportXml() {
        return "importXml";
    }

    @RequestMapping(value = "actionXml")
    public String updateFromXml(@RequestParam("xml") MultipartFile part, HttpSession session) throws IOException, ServiceException {
        Account accountFromSession = (Account) session.getAttribute("account");
        xstream.processAnnotations(Account.class);
        Account accountFromXml = (Account) xstream.fromXML(part.getInputStream());
        accountFromXml.setFoto(accountFromSession.getFoto());
        accountFromXml.setPassword(accountFromSession.getPassword());
        accountFromXml.setSkype(accountFromSession.getSkype());
        accountService.updateAccount(accountFromXml);
        session.setAttribute("account", accountFromXml);
        return "account";
    }
}