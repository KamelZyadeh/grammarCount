package com.zyadeh.kamel.command.impl;

import com.zyadeh.kamel.command.Command;
import com.zyadeh.kamel.entities.Text;
import com.zyadeh.kamel.exceptions.ServiceException;
import com.zyadeh.kamel.obj.Page;
import com.zyadeh.kamel.service.impl.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PreviousCommand implements Command {
    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        Page page = new Page("/pages/text.jsp", true);
        Service service = new Service();

        HttpSession session = req.getSession();
        Text currentText = (Text) session.getAttribute("savedText");
        Text otherText = (Text) session.getAttribute("oldText");
        if (otherText != null) {
           int otherId = otherText.getId();
           int newId = otherId - 1;
           Text text = service.read(newId);
           session.setAttribute("oldText", text);
        } else {
            int initialId = currentText.getId();
            System.out.println(initialId);
            int newId = initialId - 1;
            System.out.println(newId);
            Text text = service.read(newId);
            System.out.println(text.getId());

            session.setAttribute("oldText", text);
        }
        return page;
    }
}
