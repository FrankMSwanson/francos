package com.francos.restaurant.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.francos.restaurant.domain.back.FoodItem;
import com.francos.restaurant.repository.FoodItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * REST controller for managing FoodItem.
 */
@RestController
@RequestMapping("/app")
public class FoodItemResource {

    private final Logger log = LoggerFactory.getLogger(FoodItemResource.class);

    @Inject
    private FoodItemRepository FoodItemRepository;

    /**
     * POST  /rest/FoodItems -> Create a new FoodItem.
     */
    @RequestMapping(value = "/rest/FoodItems",
            method = RequestMethod.POST,
            produces = "application/json")
    @Timed
    public void create(@RequestBody FoodItem FoodItem) {
        log.debug("REST request to save FoodItem : {}", FoodItem);
        FoodItemRepository.save(FoodItem);
    }

    /**
     * GET  /rest/FoodItems -> get all the FoodItems.
     */
    @RequestMapping(value = "/rest/FoodItems",
            method = RequestMethod.GET,
            produces = "application/json")
    @Timed
    public List<FoodItem> getAll() {
        log.debug("REST request to get all FoodItems");
        return FoodItemRepository.findAll();
    }

    /**
     * GET  /rest/FoodItems/:id -> get the "id" FoodItem.
     */
    @RequestMapping(value = "/rest/FoodItems/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    @Timed
    public FoodItem get(@PathVariable Long id, HttpServletResponse response) {
        log.debug("REST request to get FoodItem : {}", id);
        FoodItem FoodItem = FoodItemRepository.findOne(id);
        if (FoodItem == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return FoodItem;
    }

    /**
     * DELETE  /rest/FoodItems/:id -> delete the "id" FoodItem.
     */
    @RequestMapping(value = "/rest/FoodItems/{id}",
            method = RequestMethod.DELETE,
            produces = "application/json")
    @Timed
    public void delete(@PathVariable Long id, HttpServletResponse response) {
        log.debug("REST request to delete FoodItem : {}", id);
        FoodItemRepository.delete(id);
    }
}
