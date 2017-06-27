package com.getjavajob.training.web1610.webapp.controllers;

import com.getjavajob.training.web1610.common.Group;
import com.getjavajob.training.web1610.service.GroupService;
import com.getjavajob.training.web1610.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class GroupController {
    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/logo")
    @ResponseBody
    public byte[] logo(@RequestParam("id") Integer id) throws IOException, ServiceException {
        return groupService.getById(id).getLogo();
    }

    @RequestMapping(value = "/groupsAction")
    public ModelAndView showGroupsAccount() throws IOException {
        List<Group> groups = null;
        try {
            groups = groupService.getAllGroup();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView("groups");
        modelAndView.addObject("groups", groups);
        return modelAndView;
    }
}