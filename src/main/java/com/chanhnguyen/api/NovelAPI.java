package com.chanhnguyen.api;

import com.chanhnguyen.entity.Category;
import com.chanhnguyen.entity.Chapter;
import com.chanhnguyen.entity.Comment;
import com.chanhnguyen.entity.Novel;
import com.chanhnguyen.paging.PageRequest;
import com.chanhnguyen.paging.Pageble;
import com.chanhnguyen.service.INovelService;
import com.chanhnguyen.sorter.Sorter;
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

@WebServlet(urlPatterns = {"/api/novel"})
public class NovelAPI extends HttpServlet {
    @Inject
    private com.chanhnguyen.service.INovelService INovelService;

    @Inject
    private com.chanhnguyen.service.IChapterService IChapterService;

    @Inject
    private com.chanhnguyen.service.ICommentService ICommentService;

    @Inject
    private com.chanhnguyen.service.ICategoryService ICategoryService;

    private final Gson gson = new Gson();

    //GET return an object or object list
    //POST, PUT return an object
    //DELETE no return
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String s;
        String sortName = req.getParameter("sortName");
        String sortBy = req.getParameter("sortBy");
        String currentPage = req.getParameter("currentPage");
        String limit = req.getParameter("limit");
        //Trường hợp có id thì trả về chi tiết bài viết
        //Không có id nhưng có category-id thì trả về danh sách bài viết thuộc thể loại tương ứng
        //Nếu có tham số phân trang và sắp xếp thì trả về danh sách có phân trang và sắp xếp
        //Nếu không thì trả về danh sách bài viết không phân trang
        if(req.getParameter("id")!=null){

            Novel Novel = INovelService.findById(Integer.valueOf(req.getParameter("id")));
            //n - 1 with chapter
            List<Chapter> chapters = IChapterService.findAll(Novel.getId());
            Novel.setChapters(chapters);
            //n - 1 with comment
            List<Comment> comments = ICommentService.findAll(Novel.getId());
            Novel.setComments(comments);
            //n - n with category
            s = gson.toJson(Novel);
        }
        else if(req.getParameter("category-id")!= null){
            if(currentPage != null && limit != null && sortName != null && sortBy != null){
                Pageble pageble = new PageRequest(Integer.valueOf(currentPage),Integer.valueOf(limit), new Sorter(sortName, sortBy));
                List<Novel> list = INovelService.findAllByCategoryId(Integer.valueOf(req.getParameter("category-id")), pageble);
                s = gson.toJson(list);
            }
            else {
                List<Novel> list = INovelService.findAllByCategoryId(Integer.valueOf(req.getParameter("category-id")));
                s = gson.toJson(list);
            }
        }
        else {
            List<Novel> list = INovelService.findAll();
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
        Novel Novel = HttpUtil.of(req.getReader()).toModel(Novel.class);
        if (Novel.getId() == null) {
            //Kiểm tra dữ liệu ở tầng service, nếu dữ liệu không hợp lý c sẽ là null
            //Nếu sảy ra lỗi
            Novel c = INovelService.insert(Novel);
            //Step 3: Send JSON data to client
            resp.setContentType("application/json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(resp.getOutputStream(), c);
        }
    }

    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        Novel Novel = HttpUtil.of(req.getReader()).toModel(Novel.class);
        if (Novel.getId() != null) {
            resp.setContentType("application/json");
            Novel c = INovelService.update(Novel);
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(resp.getOutputStream(), c);
        }
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        //Novel Novel = HttpUtil.of(req.getReader()).toModel(Novel.class);
        if (req.getParameter("id") != null) {
            INovelService.delete(Integer.valueOf(req.getParameter("id")));
            resp.setContentType("application/json");
            ObjectMapper mapper = new ObjectMapper();
            //No return
            mapper.writeValue(resp.getOutputStream(), "");
        }
    }
}
