package com.francos.restaurant.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.francos.restaurant.domain.front.MenuItem;
import com.francos.restaurant.repository.MenuRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * REST controller for managing Menu.
 */
@RestController
@RequestMapping("/app")
public class MenuResource {

    private final Logger log = LoggerFactory.getLogger(MenuResource.class);

    @Inject
    private MenuRepository menuRepository;

    /**
     * POST  /rest/menus -> Create a new menu.
     */
    @RequestMapping(value = "/rest/menus",
            method = RequestMethod.POST,
            produces = "application/json")
    @Timed
    public void create(@RequestBody MenuItem menuItem) {
        log.debug("REST request to save Menu : {}", menuItem);
        menuRepository.save(menuItem);
    }

    /**
     * GET  /rest/menus -> get all the menus.
     */
    @RequestMapping(value = "/rest/menus",
            method = RequestMethod.GET,
            produces = "application/json")
    @Timed
    public List<MenuItem> getAll() {
        log.debug("REST request to get all Menus");
        return menuRepository.findAll();
    }

    /**
     * GET  /rest/menus/:id -> get the "id" menu.
     */
    @RequestMapping(value = "/rest/menus/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    @Timed
    public MenuItem get(@PathVariable Long id, HttpServletResponse response) {
        log.debug("REST request to get Menu : {}", id);
        MenuItem menuItem = menuRepository.findOne(id);
        if (menuItem == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return menuItem;
    }

    /**
     * DELETE  /rest/menus/:id -> delete the "id" menu.
     */
    @RequestMapping(value = "/rest/menus/{id}",
            method = RequestMethod.DELETE,
            produces = "application/json")
    @Timed
    public void delete(@PathVariable Long id, HttpServletResponse response) {
        log.debug("REST request to delete Menu : {}", id);
        menuRepository.delete(id);
    }
}
