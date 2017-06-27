package com.getjavajob.training.web1610.webapp.controllers;

import com.getjavajob.training.web1610.common.Account;
import com.getjavajob.training.web1610.service.AccountService;
import com.getjavajob.training.web1610.service.GroupService;
import com.getjavajob.training.web1610.service.exception.ServiceException;
import com.getjavajob.training.web1610.webapp.util.ConvertByteArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.getjavajob.training.web1610.webapp.util.DeleteNullValueFromList.clean;
import static com.getjavajob.training.web1610.webapp.util.Sha256.calculateSha256;
import static com.getjavajob.training.web1610.webapp.util.Sha256.checkPassword;

@Controller
public class AccountController {
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
    @Autowired
    private AccountService accountService;
    @Autowired
    private GroupService groupService;

    @InitBinder
    private void dateBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, editor);
    }

    @RequestMapping(value = "*")
    public String welcomePage() {
        return "login";
    }

    @RequestMapping(value = "/login-in", method = RequestMethod.POST)
    public ModelAndView loginIn(@RequestParam("email") String email,
                                @RequestParam("password") String password,
                                @RequestParam(value = "remember", required = false) String remember,
                                HttpSession session, HttpServletResponse response) {
        ModelAndView resultModelAndView;
        logger.info("login " + email);
        Account account = null;
        try {
            account = accountService.getByEmail(email);
        } catch (ServiceException e) {
            logger.error("Failed login", e);
        }
        if (account != null && checkPassword(account.getPassword(), password)) {
            if (remember != null) {
                Cookie cookieEmail = new Cookie("email", email);
                response.addCookie(cookieEmail);
            }
            System.out.println(account.getDateOfBirth().toString());
            session.setAttribute("account", account);
            resultModelAndView = new ModelAndView("redirect:/account");
        } else {
            resultModelAndView = new ModelAndView("redirect: /login");
        }
        return resultModelAndView;
    }

    @RequestMapping(value = "/photo", method = RequestMethod.GET)
    @ResponseBody
    public byte[] photoShow(@RequestParam("email") String email) throws IOException, ServiceException {
        return accountService.getByEmail(email).getFoto();
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String accountPage() {
        return "account";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView accountEdit(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("editAccount");
        Account account = (Account) session.getAttribute("account");
        modelAndView.addObject("account", account);
        return modelAndView;
    }

    @RequestMapping(value = "updateAccount", method = RequestMethod.POST)
    public String editingAccount(@ModelAttribute("account") Account account, HttpSession session) throws ServiceException {
        Account sessionAccount = (Account) session.getAttribute("account");
        account.setPhones(clean(account.getPhones()));
        logger.info(account.getDateOfBirth().toString());
        account.setFoto(sessionAccount.getFoto());
        account.setPassword(calculateSha256(account.getPassword()));
        accountService.updateAccount(account);
        session.setAttribute("account", account);
        logger.info("success update account");
        return "account";
    }

    @RequestMapping(value = "/changeFotoAction", method = RequestMethod.GET)
    public ModelAndView changeFoto() {
        ModelAndView modelAndView = new ModelAndView("changeFoto");
        logger.info("success change foto");
        return modelAndView;
    }


    @RequestMapping(value = "/updateFoto", method = RequestMethod.POST)
    public ModelAndView changeAccountFoto(@RequestParam("foto") MultipartFile part, HttpSession session) throws ServiceException, IOException {
        System.out.println(part.getSize());
        Account accountFromSession = (Account) session.getAttribute("account");
        if (part.getSize() != 0) {
            InputStream inputStream = part.getInputStream();
            accountFromSession.setFoto(ConvertByteArray.getBytesFromInputStream(inputStream));
            accountService.updateAccount(accountFromSession);
        }
        ModelAndView modelAndView = new ModelAndView("account");
        session.setAttribute("account", accountFromSession);
        return modelAndView;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session, HttpServletResponse response) {
        Cookie cookie = new Cookie("email", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        session.invalidate();
        return new ModelAndView("redirect: *");
    }

    @RequestMapping(value = "friendsAction")
    public ModelAndView friendsView(HttpSession session) {
        List<Account> friends = null;
       /* try {
            friends = accountService.getAllFriends((Account) session.getAttribute("account"));
        } catch (ServiceException e) {
            e.printStackTrace();
        }*/
        ModelAndView modelAndView = new ModelAndView("friends");
        modelAndView.addObject("friends", friends);
        logger.info("show friend account");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registrationPage() {
        ModelAndView modelAndView = new ModelAndView("registration");
        modelAndView.addObject("account", new Account());
        return modelAndView;
    }

    @RequestMapping(value = "/create_account", method = RequestMethod.POST)
    public String registrationAction(@ModelAttribute("account") Account account) throws ServiceException, IOException {
        account.setPassword(calculateSha256(account.getPassword()));
        accountService.createAccount(account);
        return "login";
    }

    @RequestMapping(value = "/viewAccount")
    public ModelAndView viewAccount(@RequestParam("email") String email, @RequestParam("action") String action) throws ServiceException {
        ModelAndView modelAndView = null;
        if (action.equalsIgnoreCase("display")) {
            Account account = accountService.getByEmail(email);
            modelAndView = new ModelAndView("displayAccount");
            modelAndView.addObject("displayAccount", account);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/view")
    public ModelAndView viewAccountSearch(@PathVariable Integer id) throws ServiceException {
        Account account = accountService.getById(id);
        ModelAndView modelAndView = new ModelAndView("displayAccount");
        modelAndView.addObject("displayAccount", account);
        return modelAndView;
    }
}