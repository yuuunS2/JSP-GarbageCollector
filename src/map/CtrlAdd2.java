package map;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Util;

import common.Controller;
import common.RequestMapping;


@RequestMapping("/apple_add2.do")
public class CtrlAdd2 implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String gul = Util.h(request.getParameter("gul"));
		BangMyungVO vo = new BangMyungVO();
		vo.setGul(gul);
		
        BangMyungDAO dao = new MapDAO_OracleImpl();
        dao.add(vo);
		
		System.out.println("ControllerAdd2");
		return "redirect:/apple_list.do";
	}

}
