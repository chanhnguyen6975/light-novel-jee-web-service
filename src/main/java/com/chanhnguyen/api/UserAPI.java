package com.chanhnguyen.api;

import com.chanhnguyen.entity.User;
import com.chanhnguyen.service.IUserService;
import com.chanhnguyen.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/api/user"})

public class UserAPI extends HttpServlet {
    @Inject
    private IUserService IUserService;

    private final Gson gson = new Gson();

    //GET return an object or object list
    //POST, PUT return an object
    //DELETE no return
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String s;
        if (req.getParameter("id") != null) {
            User User = IUserService.findById(Integer.valueOf(req.getParameter("id")));
            s = gson.toJson(User);
        } else {
            List<User> list = IUserService.findAll();
            s = gson.toJson(list);
        }
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(s);
        out.flush();
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String s;
        User User = HttpUtil.of(req.getReader()).toModel(User.class);
        s = gson.toJson(IUserService.findByUsernameAndPasswordAndStatus(User.getUsername(), User.getPassword()));

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(s);
        out.flush();
    }

    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        User User = HttpUtil.of(req.getReader()).toModel(User.class);
        if (User.getId() != null) {
            resp.setContentType("application/json");
            User c = IUserService.update(User);
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(resp.getOutputStream(), c);
        }
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        //User User = HttpUtil.of(req.getReader()).toModel(User.class);
        if (req.getParameter("id") != null) {
            IUserService.delete(Integer.valueOf(req.getParameter("id")));
            resp.setContentType("application/json");
            ObjectMapper mapper = new ObjectMapper();
            //No return
            mapper.writeValue(resp.getOutputStream(), "");
        }
    }
}