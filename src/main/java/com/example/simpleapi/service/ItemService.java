package com.example.simpleapi.service;

import com.example.simpleapi.dto.ItemRequest;
import com.example.simpleapi.entity.Item;
import com.example.simpleapi.exception.ResourceNotFoundException;
import com.example.simpleapi.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository repository;

    public List<Item> findAll() {
        return repository.findAll();
    }

    public Item findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found: " + id));
    }

    public Item create(ItemRequest req) {
        return repository.save(Item.builder().name(req.name()).description(req.description()).build());
    }

    public Item update(Long id, ItemRequest req) {
        Item item = findById(id);
        item.setName(req.name());
        item.setDescription(req.description());
        return repository.save(item);
    }

    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
