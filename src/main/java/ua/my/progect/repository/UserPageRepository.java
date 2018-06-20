package ua.my.progect.repository;

import ua.my.progect.model.Page;

import java.util.Collection;

public interface UserPageRepository {
    Page save(Page page);

    void delete(int id);

    Page get(int id);

    Collection<Page> getAll();
}
