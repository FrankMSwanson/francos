package com.francos.restaurant.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.francos.restaurant.domain.front.MenuItem;
import com.francos.restaurant.repository.MenuItemRepository;
import com.francos.restaurant.web.rest.converter.MenuItemCnv;
import com.francos.restaurant.web.rest.dto.MenuItemDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * REST controller for managing Menu.
 */
@RestController
@RequestMapping("/app")
public class MenuResource {

    private final Logger log = LoggerFactory.getLogger(MenuResource.class);

    @Inject
    private MenuItemRepository menuItemRepository;

    /**
     * POST  /rest/menus -> Create a new menu.
     */
    @RequestMapping(value = "/rest/menus",
            method = RequestMethod.POST,
            produces = "application/json")
    @Timed
    public void create(@RequestBody MenuItemDTO menuItemDTO) {
        log.debug("REST request to save Menu : {}", menuItemDTO);

        MenuItem menuItem = new MenuItem();
        MenuItemCnv.copyFields(menuItem, menuItemDTO);
        menuItemRepository.save(menuItem);
    }

    /**
     * GET  /rest/menus -> get all the menus.
     */
    @RequestMapping(value = "/rest/menus",
            method = RequestMethod.GET,
            produces = "application/json")
    @Timed
    public List<MenuItemDTO> getAll() {
        log.debug("REST request to get all Menus");
        List<MenuItemDTO> menuItemDTOs = new ArrayList<>();
        for(MenuItem menuItem: menuItemRepository.findAll()){
            menuItemDTOs.add(MenuItemCnv.toDTO(menuItem));
        }
        return menuItemDTOs;
    }

    /**
     * GET  /rest/menus/:id -> get the "id" menu.
     */
    @RequestMapping(value = "/rest/menus/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    @Timed
    public MenuItemDTO get(@PathVariable Long id, HttpServletResponse response) {
        log.debug("REST request to get Menu : {}", id);
        MenuItemDTO MenuItemDTO = MenuItemCnv.toDTO(menuItemRepository.findOne(id));
        if (MenuItemDTO == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return MenuItemDTO;
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
        menuItemRepository.delete(id);
    }
}
