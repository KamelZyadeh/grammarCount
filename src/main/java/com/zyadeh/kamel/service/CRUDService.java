package com.zyadeh.kamel.service;

import com.zyadeh.kamel.exceptions.ServiceException;

public abstract class CRUDService<T> {

    public abstract void create(T entity) throws ServiceException;

    public abstract T read(int id) throws ServiceException, ServiceException;

    public abstract void update(T entity) throws ServiceException;

    public abstract void delete(T entity) throws ServiceException;
}
