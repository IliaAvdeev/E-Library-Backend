package com.bookwarm.library.services;

import com.bookwarm.library.persistence.model.Cycle;
import com.bookwarm.library.persistence.repositories.CycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CycleService {
    @Autowired
    private CycleRepository cycleRepository;

    public Iterable<Cycle> findAll() {
        return cycleRepository.findAll();
    }

    public List<Cycle> findPaginated(int page, int size) {
        return cycleRepository.findAll(PageRequest.of(page, size)).toList();
    }

    public List<Cycle> findByName(String cycleName) {
        return cycleRepository.findByName(cycleName);
    }

    public Cycle findOne(long id) {
        return cycleRepository.findById(id)
                .orElse(null);
    }

    public Cycle create(Cycle cycle) {
        return cycleRepository.save(cycle);
    }

    public void delete(long id) {
        if (cycleRepository.existsById(id)) {
            cycleRepository.deleteById(id);
        }
    }

    public void deleteAll(List<Long> ids) {
        if (ids.stream().allMatch(id -> cycleRepository.existsById(id))) {
            cycleRepository.deleteAllById(ids);
        }
    }

    public Cycle updateCycle(Cycle cycle, long id) {
        if ((cycle.getId() == id) && (cycleRepository.existsById(id))){
            return cycleRepository.save(cycle);
        } return null;
    }
}