package com.asayama.demo.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerServlet extends HttpServlet {

	private static final long serialVersionUID = -6817864708195045206L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		resp.getWriter().write(")]}[{ name:'Yuki', city:'Paris' },{ name:'Sarah' city:'Paris' }]");
		resp.flushBuffer();
	}
}
