package ua.my.progect.repository;

import ua.my.progect.model.Page;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryUserPages implements UserPageRepository {
    private Map<Integer, Page> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger();

    {
        save(new Page(null, "Start page", "admin", LocalDateTime.of(2018, Month.JULY, 1, 10, 0), "Page text"));
        save(new Page(null, "Options page", "admin", LocalDateTime.of(2018, Month.JULY, 1, 10, 0), "Page text"));
        save(new Page(null, "Page_1", "admin", LocalDateTime.of(2018, Month.JULY, 1, 10, 0), "Page text"));
        save(new Page(null, "Page_2", "admin", LocalDateTime.of(2018, Month.JULY, 1, 10, 0), "Page text"));
        save(new Page(null, "Page_3", "admin", LocalDateTime.of(2018, Month.JULY, 1, 10, 0), "Page text"));
        save(new Page(null, "Page_4", "admin", LocalDateTime.of(2018, Month.JULY, 1, 10, 0), "Page text"));
        save(new Page(null, "Page_5", "admin", LocalDateTime.of(2018, Month.JULY, 1, 10, 0), "Page text"));
        save(new Page(null, "Page_6", "admin", LocalDateTime.of(2018, Month.JULY, 1, 10, 0), "Page text"));
    }

    @Override
    public Page save(Page page) {
        if (page.isNew()) {
            page.setId(counter.incrementAndGet());
        }
        return repository.put(page.getId(), page);
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
