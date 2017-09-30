package com.onecreation.controllers

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestPropertySource

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc

@RunWith(SpringRunner)
@WebMvcTest(MessengerWebHookController.class)
@ActiveProfiles("test")
class MessengerWebhookControllerTests {

    @Autowired
    private MockMvc mockMvc

    @Test
    void makeSureTokenSendsChallengeCode() {
        String challenge = "pass123"
        String token = "test-token"
        this.mockMvc
                .perform(get("/webhook?hub.verify_token=${token}&hub.challenge=${challenge}&hub.subscribe=mode"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(challenge)))
    }

    @Test
    void returnInvalidChallengeIfTokensDontMatch(){
        String challenge = "invalid_token"
        String token = "not-test-token"
        this.mockMvc
                .perform(get("/webhook?hub.verify_token=${token}&hub.challenge=${challenge}&hub.subscribe=mode"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(challenge)))
    }

    @Test
    void doAGoogleSearchWhenWeReceiveARequestToFindALocation(){

    }
}
