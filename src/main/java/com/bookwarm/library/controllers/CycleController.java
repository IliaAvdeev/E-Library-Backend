package com.bookwarm.library.controllers;

import com.bookwarm.library.persistence.model.Cycle;
import com.bookwarm.library.services.CycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cycles")
@CrossOrigin(origins = "http://localhost:4200")
public class CycleController {
    @Autowired
    private CycleService cycleService;

    @GetMapping
    public Iterable<Cycle> findAll() {
        return cycleService.findAll();
    }

    @GetMapping(params = { "page", "size" })
    public List<Cycle> findPaginated(@RequestParam("page") int page, @RequestParam("size") int size) {
        return cycleService.findPaginated(page, size);
    }

    @GetMapping("/name/{cycleName}")
    public List<Cycle> findByName(@PathVariable String cycleName) {
        return cycleService.findByName(cycleName);
    }

    @GetMapping("/{id}")
    public Cycle findOne(@PathVariable long id) {
        return cycleService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cycle create(@RequestBody Cycle cycle) {
        return cycleService.create(cycle);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        cycleService.delete(id);
    }

    @PostMapping("/bulkDelete")
    public void deleteAll(@RequestBody List<Long> ids) {
        cycleService.deleteAll(ids);
    }

    @PutMapping("/{id}")
    public Cycle updateCycle(@RequestBody Cycle cycle, @PathVariable long id) {
        return cycleService.updateCycle(cycle, id);
    }
}

