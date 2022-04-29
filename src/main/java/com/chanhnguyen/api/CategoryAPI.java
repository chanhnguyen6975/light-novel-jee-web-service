package com.chanhnguyen.api;

import com.chanhnguyen.entity.Category;
import com.chanhnguyen.service.ICategoryService;
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

@WebServlet(urlPatterns = {"/api/category"})
public class CategoryAPI extends HttpServlet {
    @Inject
    private ICategoryService ICategoryService;

    private final Gson gson = new Gson();

    //GET return an object or object list
    //POST, PUT return an object
    //DELETE no return
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String s;
        if(req.getParameter("id")!=null){
            Category Category = ICategoryService.findById(Integer.valueOf(req.getParameter("id")));
            s = gson.toJson(Category);
        }
        else {
            List<Category> list = ICategoryService.findAll();
            s = gson.toJson(list);
        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(s);
        out.flush();
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //JSON is a string, set UTF-8 to understand Vietnamese
        req.setCharacterEncoding("UTF-8");
        //Step 1: Convert JSON to Model
        Category Category = HttpUtil.of(req.getReader()).toModel(Category.class);
        if (Category.getId() == null) {
            //Kiểm tra dữ liệu ở tầng service, nếu dữ liệu không hợp lý c sẽ là null
            //Nếu sảy ra lỗi
            Category c = ICategoryService.insert(Category);
            //Step 3: Send JSON data to client
            resp.setContentType("application/json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(resp.getOutputStream(), c);
        }

    }

    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        Category Category = HttpUtil.of(req.getReader()).toModel(Category.class);
        if (Category.getId() != null) {
            resp.setContentType("application/json");
            Category c = ICategoryService.update(Category);
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(resp.getOutputStream(), c);
        }
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        //Category Category = HttpUtil.of(req.getReader()).toModel(Category.class);
        if (req.getParameter("id") != null) {
            ICategoryService.delete(Integer.valueOf(req.getParameter("id")));
            resp.setContentType("application/json");
            ObjectMapper mapper = new ObjectMapper();
            //No return
            mapper.writeValue(resp.getOutputStream(), "");
        }
    }
}
