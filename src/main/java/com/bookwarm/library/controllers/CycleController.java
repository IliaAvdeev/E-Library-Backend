package com.bookwarm.library.controllers;

import com.bookwarm.library.persistence.model.Cycle;
import com.bookwarm.library.services.CycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class CycleController {
    @Autowired
    private CycleService cycleService;

    @GetMapping("/cycles")
    public Iterable<Cycle> findAll() {
        return cycleService.findAll();
    }

    @GetMapping(value = "/cycles", params = {"page", "size"})
    public List<Cycle> findPaginated(@RequestParam("page") int page, @RequestParam("size") int size) {
        return cycleService.findPaginated(page, size);
    }

    @GetMapping("/cycles/{id}")
    public Cycle findOne(@PathVariable long id) {
        return cycleService.findOne(id);
    }

    @PostMapping("/admin/cycles/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Cycle create(@RequestBody Cycle cycle) {
        return cycleService.create(cycle);
    }

    @DeleteMapping("/admin/cycles/delete/{id}")
    public void delete(@PathVariable long id) {
        cycleService.delete(id);
    }

    @PostMapping("/admin/cycles/delete/multiple")
    public void deleteAll(@RequestBody List<Long> ids) {
        cycleService.deleteAll(ids);
    }

    @PutMapping("/admin/cycles/update/{id}")
    public Cycle update(@RequestBody Cycle cycle, @PathVariable long id) {
        return cycleService.update(cycle, id);
    }
}

