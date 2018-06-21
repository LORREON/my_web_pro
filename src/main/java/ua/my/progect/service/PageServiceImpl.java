package ua.my.progect.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.my.progect.model.Page;
import ua.my.progect.repository.PageRepository;
import ua.my.progect.util.exception.NotFoundException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static ua.my.progect.util.ValidationUtil.checkNotFoundWithId;

@Service
public class PageServiceImpl implements PageService {

    @Autowired
    private PageRepository repository;

    @Override
    public Page create(Page page, int userId) {
        return repository.save(page, userId);
    }

    @Override
    public void delete(int id, int userId) throws NotFoundException {
        repository.delete(id, userId);
    }

    @Override
    public Page get(int id, int userId) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id, userId), id);
    }

    @Override
    public void update(Page page, int userId) {
        checkNotFoundWithId(repository.save(page, userId), page.getId());
    }

    @Override
    public List<Page> getAll(int userId) {
        List<Page> list = repository.getAll(userId);
        return list;
    }
}