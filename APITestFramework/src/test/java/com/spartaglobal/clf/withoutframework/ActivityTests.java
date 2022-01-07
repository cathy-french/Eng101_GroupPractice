package com.spartaglobal.clf.withoutframework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spartaglobal.clf.withoutframework.pojo.ActivityPOJO;
import org.junit.jupiter.api.*;


import java.io.IOException;
import java.net.URL;

public class ActivityTests {

    private static ActivityPOJO activityPOJO;
   @BeforeAll
    public static void init() {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            activityPOJO = objectMapper.readValue(new URL("http://www.boredapi.com/api/activity/"), ActivityPOJO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Nested
    @DisplayName("Checking the type is correct")
    public class CheckForType {
        @Test
        @DisplayName("Check that the activity is a String")
        public void checkActivityString() {
            Assertions.assertEquals(String.class, activityPOJO.getActivity().getClass());
        }

        @Test
        @DisplayName("Check that the price is a Double")
        public void checkThatPriceIsADouble() {
            Assertions.assertEquals(Double.class, activityPOJO.getPrice().getClass());
        }

        @Test
        @DisplayName("Check that the number of participants is an Integer")
        void checkThatParticipantsIsAnInteger() {
            Assertions.assertEquals(Integer.class, activityPOJO.getParticipants().getClass());
        }

        @Test
        @DisplayName("Check that the number of participants is an Integer second way")
        void checkThatParticipantsIsAnInteger2() {
            Assertions.assertTrue(activityPOJO.getParticipants() instanceof Integer);
        }
    }

    @Nested
    @DisplayName("Check the value is correct")
    public class CheckForValue {
        @Test
        @DisplayName("Check that the key is always seven digits")
        public void checkKeyHas7Digits() {
            Assertions.assertEquals(7, activityPOJO.getKey().length());
        }


        @Test
        @DisplayName("Check that activity has at least one participant")
        void checkThatActivityHasAtLeastOneParticipant() {
            Assertions.assertTrue(activityPOJO.getParticipants() >= 1);
        }

        @Test
        @DisplayName("Check that activity is not null")
        void checkThatActivityIsNotNull() {
            Assertions.assertNotNull(activityPOJO.getActivity());
        }
    }
}
