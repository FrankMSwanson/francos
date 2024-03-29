package com.francos.restaurant.web.rest;

import com.francos.restaurant.Application;
import com.francos.restaurant.domain.front.GuestOrder;
import com.francos.restaurant.repository.GuestOrderRepository;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.inject.Inject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Test class for the GuestOrderResource REST controller.
 *
 * @see GuestOrderResource
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class })
@ActiveProfiles("dev")
public class GuestOrderResourceTest {

    private static final Logger log = LoggerFactory.getLogger(GuestOrderResourceTest.class);
    private static final Long DEFAULT_ID = new Long(1L);

    private static final LocalDate DEFAULT_SAMPLE_DATE_ATTR = new LocalDate(0L);

    private static final LocalDate UPD_SAMPLE_DATE_ATTR = new LocalDate();

    private static final String DEFAULT_SAMPLE_TEXT_ATTR = "sampleTextAttribute";

    private static final String UPD_SAMPLE_TEXT_ATTR = "sampleTextAttributeUpt";

    @Inject
    private GuestOrderRepository guestorderRepository;

    private MockMvc restGuestOrderMockMvc;
    
    private GuestOrder guestorder;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        GuestOrderResource guestorderResource = new GuestOrderResource();
        ReflectionTestUtils.setField(guestorderResource, "guestorderRepository", guestorderRepository);

        this.restGuestOrderMockMvc = MockMvcBuilders.standaloneSetup(guestorderResource).build();

        guestorder = new GuestOrder();
        guestorder.setId(DEFAULT_ID);
    }

    @Test
    public void testCRUDGuestOrder() throws Exception {

    	// Create GuestOrder
    	restGuestOrderMockMvc.perform(post("/app/rest/guestorders")
    			.contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(guestorder)))
                .andExpect(status().isOk());

    	// Read GuestOrder
    	restGuestOrderMockMvc.perform(get("/app/rest/guestorders/{id}", DEFAULT_ID))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(DEFAULT_ID.intValue()));
    			//.andExpect(jsonPath("$.sampleDateAttribute").value(DEFAULT_SAMPLE_DATE_ATTR.toString()))
    			//.andExpect(jsonPath("$.sampleTextAttribute").value(DEFAULT_SAMPLE_TEXT_ATTR));

        //Need to move this to a dto
        guestorder = guestorderRepository.findOne(DEFAULT_ID);
        guestorder.setTableName("a table");
        log.debug("stuff things");
        log.debug(TestUtil.convertObjectToJsonBytes(guestorder).toString());

        log.debug("got guetOrder {}", guestorder.getCreatedBy());
        restGuestOrderMockMvc.perform(post("/app/rest/guestorders")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(guestorder)))
                .andExpect(status().isOk());

    	// Read updated GuestOrder
    	restGuestOrderMockMvc.perform(get("/app/rest/guestorders/{id}", DEFAULT_ID))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(DEFAULT_ID.intValue()));
    			//.andExpect(jsonPath("$.sampleDateAttribute").value(UPD_SAMPLE_DATE_ATTR.toString()))
    			//.andExpect(jsonPath("$.sampleTextAttribute").value(UPD_SAMPLE_TEXT_ATTR));

    	// Delete GuestOrder
    	restGuestOrderMockMvc.perform(delete("/app/rest/guestorders/{id}", DEFAULT_ID)
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

    	// Read nonexisting GuestOrder
    	restGuestOrderMockMvc.perform(get("/app/rest/guestorders/{id}", DEFAULT_ID)
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isNotFound());

    }
}
