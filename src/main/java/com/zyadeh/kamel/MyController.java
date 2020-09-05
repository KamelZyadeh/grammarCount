package com.zyadeh.kamel;

import com.zyadeh.kamel.command.Command;
import com.zyadeh.kamel.command.CommandFcatory;
import com.zyadeh.kamel.exceptions.ServiceException;
import com.zyadeh.kamel.obj.Page;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get request");
        doWork(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post request");
        doWork(req, resp);
    }

    private void doWork(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String commandValue = req.getParameter("command");
        Command command = CommandFcatory.getCommand(commandValue);
        try {
            assert command != null;
            Page page = command.execute(req);
            if (page.isRedirect()) {
                redirect(page.getUrl(), req, resp);
            } else {
                forward(page.getUrl(), req, resp);
            }
        } catch (ServiceException e) {
            throw new ServletException(e.getMessage(),e);
        }
    }

    private void redirect(String url, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + url);
    }

    private void forward(String url, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(url);
        requestDispatcher.forward(req, resp);
    }
}
