package com.getjavajob.training.web1610.webapp.controllers;

import com.getjavajob.training.web1610.common.Account;
import com.getjavajob.training.web1610.common.dto.AccountDto;
import com.getjavajob.training.web1610.service.AccountService;
import com.getjavajob.training.web1610.service.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static java.lang.Math.ceil;

@Controller
public class SearchController {
    private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
    public int countAccountsOnPage = readCountPage();
    @Autowired
    private AccountService accountService;

    public static int readCountPage() {
        Properties prop = new Properties();
        try (InputStream inputStream = SearchController.class.getResourceAsStream("/page.properties")) {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(prop.getProperty("page"));
    }

    @ResponseBody
    @RequestMapping(value = "getPage", method = RequestMethod.GET)
    public List<AccountDto> showSearch(@RequestParam("page") int page, @RequestParam("search") String search) {
        int startPage = (page - 1) * countAccountsOnPage;
        List<Account> list = accountService.pagination(search, startPage, countAccountsOnPage);
        List<AccountDto> result = new ArrayList<>();
        for (Account temp : list) {
            AccountDto accountDto = new AccountDto();
            accountDto.setId(temp.getId());
            accountDto.setFirstName(temp.getFirstName());
            accountDto.setLastName(temp.getLastName());
            accountDto.setEmail(temp.getEmail());
            accountDto.setFoto(temp.getFoto());
            result.add(accountDto);
        }
        return result;
    }

    @RequestMapping(value = "/searchAction")
    public ModelAndView viewSearchResult(@RequestParam String search) {
        ModelAndView modelAndView = new ModelAndView("searchPageAjax");
        modelAndView.addObject("accountPages", numberOfPages(search));
        modelAndView.addObject("searchString", search);
        modelAndView.addObject("total", totalNumber(search));
        logger.info(search);
        return modelAndView;
    }

    private int numberOfPages(String search) {
        return (int) ceil(accountService.countSearchResult(search) / countAccountsOnPage);
    }

    private int totalNumber(String search) {
        return accountService.countSearchResult(search);
    }

    @RequestMapping(value = "/searchAjax", method = RequestMethod.GET)
    @ResponseBody
    public List<AccountDto> searchByAjax(@RequestParam("search") String search) throws ServiceException {
        List<AccountDto> result = new ArrayList<>();
        List<Account> accountList = accountService.getSearchAccount(search);
        for (Account temp : accountList) {
            AccountDto accountDto = new AccountDto();
            accountDto.setId(temp.getId());
            accountDto.setFirstName(temp.getFirstName());
            accountDto.setLastName(temp.getLastName());
            accountDto.setEmail(temp.getEmail());
            result.add(accountDto);
        }
        return result;
    }
}
