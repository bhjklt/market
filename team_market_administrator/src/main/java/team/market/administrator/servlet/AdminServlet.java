package team.market.administrator.servlet;

import team.market.administrator.pojo.User;
import team.market.administrator.service.AdminService;
import team.market.common.annontation.RequiresPermission;
import team.market.common.servlet.BaseServlet;
import team.market.common.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminServlet extends BaseServlet {

    private AdminService service = new AdminService();

    public String login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User admin = new User();
        try {
            admin = (User)WebUtil.parseRequest(admin, req.getParameterMap(), User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean isLogin = service.login(admin);
        if(!isLogin){
            req.setAttribute("errorMsg","用户名或密码错误");
            return "/error.jsp";
        }
        return "/index.jsp";
    }
}
