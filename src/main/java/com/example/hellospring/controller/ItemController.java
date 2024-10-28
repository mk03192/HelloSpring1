package com.example.hellospring.controller;

import com.example.hellospring.dto.ItemDto;
import com.example.hellospring.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("items")
    public void save(@RequestBody ItemDto itemDto) {
        itemService.saveItem(itemDto);
    }

    @GetMapping("items/{id}")
    public ItemDto findById(@PathVariable Long id) {
        return itemService.findItemById(id);
    }

   @GetMapping("items")
    public List<ItemDto> findAll() {
        return itemService.findAllItem();
   }

   @PostMapping("items/{id}")
    public void update(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        itemService.updateItemById(id, itemDto);
   }

   @DeleteMapping("items/{id}")
    public void deleteItemBiId(@PathVariable Long id) {
        itemService.deleteItemById(id);
   }
}
