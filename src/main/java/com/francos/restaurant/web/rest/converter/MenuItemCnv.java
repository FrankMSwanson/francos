package com.francos.restaurant.web.rest.converter;

import com.francos.restaurant.domain.front.MenuItem;
import com.francos.restaurant.repository.MenuItemRepository;
import com.francos.restaurant.web.rest.dto.MenuItemDTO;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: frankswanson
 * Date: 5/6/14
 * Time: 10:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class MenuItemCnv {


    public static MenuItemDTO toDTO(MenuItem menuItem){
        MenuItemDTO midto= new MenuItemDTO();
        midto.setId(menuItem.getId());
        midto.setActive(menuItem.isActive());
        midto.setDescription(menuItem.getDescription());
        midto.setPrice(menuItem.getPrice());

        return midto;
    }


    public static MenuItem copyFields(MenuItem to, MenuItemDTO from){

        to.setActive(from.isActive());
        to.setDescription(from.getDescription());
        to.setPrice(from.getPrice());

        return to;

    }
}
