package com.zyadeh.kamel.command.impl;

import com.zyadeh.kamel.command.Command;
import com.zyadeh.kamel.entities.Text;
import com.zyadeh.kamel.exceptions.ServiceException;
import com.zyadeh.kamel.obj.Page;
import com.zyadeh.kamel.service.impl.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class NextCommand implements Command {
    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        Page page = new Page("/pages/text.jsp", true);
        Service service = new Service();

        HttpSession session = req.getSession();
        Text currentText = (Text) session.getAttribute("savedText");
        Text otherText = (Text) session.getAttribute("oldText");

        int otherId = otherText.getId();
        int initialId = currentText.getId();


        for (int i = otherId; i <= initialId; i++) {
            int newId = i;
            Text text = service.read(newId);
            session.setAttribute("newText", text);
        }


//        int newId = otherId + 1;

//        if (newId > initialId) {
//            Text text1 = new Text();
//            text1.setText("invalid request (0;0)");
//            session.setAttribute("wrongText", text1);
//        }
        return page;
    }
}
