package team.market.customer.servlet;

import team.market.common.servlet.BaseServlet;
import team.market.customer.dao.ProductDao;
import team.market.customer.dao.impl.ProductDaoImpl;
import team.market.customer.pojo.Product;
import team.market.customer.service.ProductService;
import team.market.customer.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServlet extends BaseServlet {

    private ProductService productService = new ProductServiceImpl();

    public String getList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("sid");
        Map<String,String> map = new HashMap<>();
        map.put("sid",sid);
        List<Product> products = productService.findProductsBySid(sid);
        req.setAttribute("products",products);
        return "/WEB-INF/showProductList.jsp";
    }
}
