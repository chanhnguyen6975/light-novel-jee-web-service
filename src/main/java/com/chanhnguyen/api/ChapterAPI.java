package com.chanhnguyen.api;

import com.chanhnguyen.entity.Chapter;

import com.chanhnguyen.service.IChapterService;
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

@WebServlet(urlPatterns = {"/api/chapter"})
public class ChapterAPI extends HttpServlet {
    @Inject
    private IChapterService IChapterService;

    private final Gson gson = new Gson();
//Null, rỗng khi chuyển từ JSON sang object và objects
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String s;
        if(req.getParameter("id")!=null && req.getParameter("novel-id")!=null){
            Chapter Chapter = IChapterService.findById(Integer.valueOf(req.getParameter("id")), Integer.valueOf(req.getParameter("novel-id")));
            s = gson.toJson(Chapter);
        }
        else if(req.getParameter("id")==null && req.getParameter("novel-id")!=null){
            List<Chapter> list = IChapterService.findAll(Integer.valueOf(req.getParameter("novel-id")));
            s = gson.toJson(list);
        }
        else {
            s = "";
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
        Chapter Chapter = HttpUtil.of(req.getReader()).toModel(Chapter.class);
        if (Chapter.getId() == null) {
            //Kiểm tra dữ liệu ở tầng service, nếu dữ liệu không hợp lý c sẽ là null
            //Nếu sảy ra lỗi
            Chapter c = IChapterService.insert(Chapter);
            //Step 3: Send JSON data to client
            resp.setContentType("application/json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(resp.getOutputStream(), c);
        }

    }

    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        Chapter Chapter = HttpUtil.of(req.getReader()).toModel(Chapter.class);
        if (Chapter.getId() != null) {
            resp.setContentType("application/json");
            Chapter c = IChapterService.update(Chapter);
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(resp.getOutputStream(), c);
        }
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        //Chapter Chapter = HttpUtil.of(req.getReader()).toModel(Chapter.class);
        if (req.getParameter("id") != null) {
            IChapterService.delete(Integer.valueOf(req.getParameter("id")));
            resp.setContentType("application/json");
            ObjectMapper mapper = new ObjectMapper();
            //No return
            mapper.writeValue(resp.getOutputStream(), "");
        }
    }
}
