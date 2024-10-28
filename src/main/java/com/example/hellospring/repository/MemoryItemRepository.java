package com.example.hellospring.repository;

import com.example.hellospring.domain.Item;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryItemRepository implements ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>();

    private static Long sequence = 0L;

    @Override
    public void save(Item item) {
        item.initId(++sequence);
        store.put(item.getId(), item);
    }

    @Override
    public Item findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Item> findAll() {
        return store.values().stream().toList();
    }

    @Override
    public void updateById(Long id, Item item) {
        store.put(id, item);
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }
}
