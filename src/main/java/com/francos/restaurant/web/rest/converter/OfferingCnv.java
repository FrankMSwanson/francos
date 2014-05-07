package com.francos.restaurant.web.rest.converter;

import com.francos.restaurant.domain.back.Offering;
import com.francos.restaurant.domain.type.OfferingType;
import com.francos.restaurant.repository.OfferingRepository;
import com.francos.restaurant.web.rest.dto.OfferingDTO;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: frankswanson
 * Date: 5/6/14
 * Time: 10:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class OfferingCnv {


    public static OfferingDTO toDTO(Offering offering){
        OfferingDTO offeringDTO = new OfferingDTO();
        offeringDTO.setId(offering.getId());
        offeringDTO.setOfferingType(offering.getOfferingType().getDisplay());
        offeringDTO.setDescription(offering.getDescription());
        offeringDTO.setOfferingType(offering.getOfferingType().name());
        return offeringDTO;
    }


    public static void copyFields(OfferingDTO from, Offering to){
        to.setOfferingType(OfferingType.getByDisplay(from.getOfferingType()));
        to.setCost(from.getCost());
        to.setDescription(from.getDescription());
    }

}
