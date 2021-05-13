package demo.servlet;

import demo.entity.Keyword;
import demo.service.Imp.keywordServiceImp;
import demo.service.keywordService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Servlet1 extends javax.servlet.http.HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集
        req.setCharacterEncoding("UTF-8");
        //设置响应格式
        resp.setContentType("text/html;charset=UTF-8");
        //定义输出out
        PrintWriter out=resp.getWriter();

        //查询数据库
        keywordService  keywordService=new keywordServiceImp();

        //rep设置属性
        List<Keyword> keywordList=keywordService.getList();
        //转发
        req.setAttribute("keywordList",keywordList);
        req.getRequestDispatcher("index.jsp").forward(req,resp);

        String opr=req.getParameter("opr");
        String id=req.getParameter("id");
        if (opr.equals("getById")){
            Keyword keyword =keywordService.getById(Integer.valueOf(id));
            //转发
            //给req 设置属性
            req.setAttribute("keyword",keyword);
            //转发
            req.getRequestDispatcher("edit.jsp").forward(req,resp);
        }else if ("update".equals(opr)){
			String hidden=req.getParameter("hidden");
			String name=req.getParameter("name");
			String type=req.getParameter("type");
			String createDate=req.getParameter("createDate");
			int res=keywordService.update(new Keyword(Integer.valueOf(hidden),name,type,createDate));
			if(res>0){
				 out.print("<script>alert('修改成功');location.href='pet'</script>");
			}else{
				  out.print("<script>alert('添加失败');history.go(-1)</script>");
			}
        }

    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
