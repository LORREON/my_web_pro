package ua.my.progect.repository;


import ua.my.progect.model.Page;
import ua.my.progect.util.Util;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryPageRepositoryImpl implements PageRepository {
    private Map<Integer, Page> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        Util.PAGE_LIST.forEach(this::save);
    }

    @Override
    public Page save(Page page) {
        if (page.isNew()) {
            page.setId(counter.incrementAndGet());
        }
        repository.put(page.getId(), page);
        return page;
    }

    @Override
    public void delete(int id) {
        repository.remove(id);
    }

    @Override
    public Page get(int id) {
        return repository.get(id);
    }

    @Override
    public Collection<Page> getAll() {
        return repository.values();
    }
}

