package ua.my.progect.repository;

import ua.my.progect.model.Page;

import java.util.List;

public interface PageRepository {
    Page save(Page page, int userId);

    boolean delete(int id, int userId);

    Page get(int id, int userId);

    List<Page> getAll(int userId);
}
