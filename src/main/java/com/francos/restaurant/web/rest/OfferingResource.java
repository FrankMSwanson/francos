package com.francos.restaurant.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.francos.restaurant.domain.back.Offering;
import com.francos.restaurant.repository.OfferingRepository;
import com.francos.restaurant.web.rest.converter.OfferingCnv;
import com.francos.restaurant.web.rest.dto.OfferingDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: frankswanson
 * Date: 5/5/14
 * Time: 10:15 PM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/app")
public class OfferingResource {

    private static final Logger log = LoggerFactory.getLogger(OfferingResource.class);

    @Inject
    private OfferingRepository offeringRepository;

    /**
     * POST  /rest/offerings -> Create a new offering.
     */
    @RequestMapping(value = "/rest/offering",
            method = RequestMethod.POST,
            produces = "application/json")
    @Timed
    public void create(@RequestBody OfferingDTO offeringDTO) {
        log.debug("REST request to save Menu : {}", offeringDTO);

        Offering offering = new Offering();
        OfferingCnv.copyFields(offeringDTO, offering);
        offeringRepository.save(offering);
    }



    /**
     * GET  /rest/offerings -> get all the offerings.
     */
    @RequestMapping(value = "/rest/offerings",
            method = RequestMethod.GET,
            produces = "application/json")
    @Timed
    public List<OfferingDTO> getAll() {
        log.debug("REST request to get all Menus");
        List<OfferingDTO> offeringDTOs = new ArrayList<>();
        for(Offering offering: offeringRepository.findAll()){
            offeringDTOs.add(OfferingCnv.toDTO(offering));
        }
        return offeringDTOs;
    }

    /**
     * GET  /rest/offerings/:id -> get the "id" offering.
     */
    @RequestMapping(value = "/rest/offerings/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    @Timed
    public OfferingDTO get(@PathVariable Long id, HttpServletResponse response) {
        log.debug("REST request to get Menu : {}", id);
        OfferingDTO OfferingDTO = OfferingCnv.toDTO(offeringRepository.findOne(id));
        if (OfferingDTO == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return OfferingDTO;
    }

    /**
     * DELETE  /rest/offerings/:id -> delete the "id" offering.
     */
    @RequestMapping(value = "/rest/offerings/{id}",
            method = RequestMethod.DELETE,
            produces = "application/json")
    @Timed
    public void delete(@PathVariable Long id, HttpServletResponse response) {
        log.debug("REST request to delete Menu : {}", id);
        offeringRepository.delete(id);
    }

}
