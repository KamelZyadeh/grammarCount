package com.zyadeh.kamel.command;

import com.zyadeh.kamel.exceptions.ServiceException;
import com.zyadeh.kamel.obj.Page;

import javax.servlet.http.HttpServletRequest;

public interface Command {

    Page execute(HttpServletRequest req) throws ServiceException;
}
