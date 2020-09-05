package com.zyadeh.kamel.service.impl;

import com.zyadeh.kamel.dao.impl.DAO;
import com.zyadeh.kamel.entities.Text;
import com.zyadeh.kamel.exceptions.DAOException;
import com.zyadeh.kamel.exceptions.ServiceException;
import com.zyadeh.kamel.service.CRUDService;


public class Service extends CRUDService<Text> {

    private DAO dao = new DAO();

    @Override
    public void create(Text entity) throws ServiceException {
        try {
            dao.insert(entity);
        } catch (DAOException e) {
            throw new ServiceException("couldn't create the text");
        }
    }

    @Override
    public Text read(int id) throws ServiceException, ServiceException {
        try {
            System.out.println("in dao");
            System.out.println(id);
            return dao.selectById(id);
        } catch (DAOException e) {
            throw new ServiceException("cant get text using id");
        }
    }

    public Text reading() throws ServiceException, ServiceException {
        Text text = new Text();
        try {
            text = dao.selectAll();
        } catch (DAOException e) {
            throw new ServiceException("getting text back from DAO");
        }
        return text;
    }


    @Override
    public void update(Text entity) throws ServiceException {

    }

    @Override
    public void delete(Text entity) throws ServiceException {

    }
}
