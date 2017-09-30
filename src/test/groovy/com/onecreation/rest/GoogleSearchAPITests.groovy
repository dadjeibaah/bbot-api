package com.onecreation.rest

import com.onecreation.models.Location
import feign.Client
import feign.Feign
import feign.Request
import feign.Response
import org.junit.Before
import org.junit.Test
import org.springframework.boot.autoconfigure.web.HttpMessageConverters
import org.springframework.boot.test.mock.mockito.*
import org.springframework.cloud.netflix.feign.support.SpringDecoder
import org.springframework.cloud.netflix.feign.support.SpringMvcContract
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter

import java.nio.charset.Charset

import static org.assertj.core.api.Assertions.*
import static org.mockito.Mockito.*;

class GoogleSearchAPITests {

    private GoogleSearchAPI googlePlaceClient
    @MockBean
    private Client mockClient

    @Before
    void setup() {
        mockClient = mock(Client)
        String json = Class.getResource("/locations.json").getText("UTF-8")
        HashMap<String, Collection<String>> headers = new HashMap<String, Collection<String>>()
        headers.put("Content-Type", Arrays.asList("application/json"))
        Response jsonResponse = Response.builder()
                .status(200)
                .headers(headers)
                .body(json, Charset.forName("UTF-8"))
                .build()
        when(mockClient.execute(any(Request.class),any(Request.Options.class))).thenReturn(jsonResponse)
        this.googlePlaceClient = Feign.builder()
                .client(mockClient)
                .contract(new SpringMvcContract())
                .decoder(new SpringDecoder(new HttpMessageConverters(new MappingJackson2HttpMessageConverter())))
                .target(GoogleSearchAPI.class, "http://localhost:8080")
    }

    @Test
    void doSomething() {
        Location loc = googlePlaceClient.locations("key", "location", "400", "word")
        assertThat(loc).isNotNull()
    }
}


