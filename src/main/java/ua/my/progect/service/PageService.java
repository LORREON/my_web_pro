package ua.my.progect.service;

import ua.my.progect.model.Page;
import ua.my.progect.util.exception.NotFoundException;

import java.util.List;

public interface PageService {

    Page create(Page page, int userId);

    void delete(int id, int userId) throws NotFoundException;

    Page get(int id, int userId) throws NotFoundException;

    void update(Page page, int userId);

    List<Page> getAll(int userId);
}