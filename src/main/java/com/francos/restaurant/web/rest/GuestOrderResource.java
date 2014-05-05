package com.francos.restaurant.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.francos.restaurant.domain.front.GuestOrder;
import com.francos.restaurant.repository.GuestOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * REST controller for managing GuestOrder.
 */
@RestController
@RequestMapping("/app")
public class GuestOrderResource {

    private final Logger log = LoggerFactory.getLogger(GuestOrderResource.class);

    @Inject
    private GuestOrderRepository guestorderRepository;

    /**
     * POST  /rest/guestorders -> Create a new guestorder.
     */
    @RequestMapping(value = "/rest/guestorders",
            method = RequestMethod.POST,
            produces = "application/json")
    @Timed
    public void create(@RequestBody GuestOrder guestorder) {
        log.debug("REST request to save GuestOrder : {}", guestorder);
        guestorderRepository.save(guestorder);
    }

    /**
     * GET  /rest/guestorders -> get all the guestorders.
     */
    @RequestMapping(value = "/rest/guestorders",
            method = RequestMethod.GET,
            produces = "application/json")
    @Timed
    public List<GuestOrder> getAll() {
        log.debug("REST request to get all GuestOrders");
        return guestorderRepository.findAll();
    }

    /**
     * GET  /rest/guestorders/:id -> get the "id" guestorder.
     */
    @RequestMapping(value = "/rest/guestorders/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    @Timed
    public GuestOrder get(@PathVariable Long id, HttpServletResponse response) {
        log.debug("REST request to get GuestOrder : {}", id);
        GuestOrder guestorder = guestorderRepository.findOne(id);
        if (guestorder == null) {
            log.debug("Its null dude");
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        //log.debug("returning guuestorder {} status is {}", guestorder.getId(), response.getStatus());
        return guestorder;
    }

    /**
     * DELETE  /rest/guestorders/:id -> delete the "id" guestorder.
     */
    @RequestMapping(value = "/rest/guestorders/{id}",
            method = RequestMethod.DELETE,
            produces = "application/json")
    @Timed
    public void delete(@PathVariable Long id, HttpServletResponse response) {
        log.debug("REST request to delete GuestOrder : {}", id);
        guestorderRepository.delete(id);
    }
}
