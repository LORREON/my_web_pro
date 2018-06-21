package ua.my.progect.repository.mock;


import org.springframework.stereotype.Repository;
import ua.my.progect.model.Page;
import ua.my.progect.repository.PageRepository;
import ua.my.progect.util.Util;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ua.my.progect.repository.mock.InMemoryUserRepositoryImpl.ADMIN_ID;
import static ua.my.progect.repository.mock.InMemoryUserRepositoryImpl.USER_ID;

@Repository
public class InMemoryPageRepositoryImpl implements PageRepository {

    private Map<Integer, Map<Integer, Page>> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        Util.PAGE_LIST.forEach(page -> save(page, USER_ID));

        save(new Page(null, "Start page admin", "admin", LocalDateTime.of(2018, Month.JULY, 1, 10, 0), "Page text"), ADMIN_ID);
        save(new Page(null, "Options page", "admin", LocalDateTime.of(2018, Month.JULY, 1, 10, 0), "Page text"), ADMIN_ID);
        save(new Page(null, "Page_1", "admin", LocalDateTime.of(2018, Month.JULY, 1, 10, 0), "Page text"), ADMIN_ID);
    }


    @Override
    public Page save(Page page, int userId) {
        Map<Integer, Page> pageMap = repository.computeIfAbsent(userId, ConcurrentHashMap::new);
        if (page.isNew()) {
            page.setId(counter.incrementAndGet());
            pageMap.put(page.getId(), page);
            return page;
        }
        return pageMap.computeIfPresent(page.getId(), (id, oldPage) -> page);
    }

    @Override
    public boolean delete(int id, int userId) {
        Map<Integer, Page> meals = repository.get(userId);
        return meals != null && meals.remove(id) != null;
    }

    @Override
    public Page get(int id, int userId) {
        Map<Integer, Page> meals = repository.get(userId);
        return meals == null ? null : meals.get(id);
    }

    @Override
    public List<Page> getAll(int userId) {
        return getAllAsStream(userId).collect(Collectors.toList());
    }


    private Stream<Page> getAllAsStream(int userId) {
        Map<Integer, Page> page = repository.get(userId);
        return page == null ?
                Stream.empty() :
                page.values().stream()
                        .sorted(Comparator.comparing(Page::getDateTime).reversed());
    }
}

