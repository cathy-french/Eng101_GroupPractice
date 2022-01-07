package com.spartaglobal.clf.withframework;
import com.spartaglobal.clf.withframework.connection.ConnectionManager;
import com.spartaglobal.clf.withframework.dto.ActivityDTO;
import com.spartaglobal.clf.withframework.injector.Injector;
import org.junit.jupiter.api.*;

public class ActivityFrameworkTests {
    private static ActivityDTO activityDTO;
    private static int statusCode;
//    private static Headers headers;

    @BeforeAll
    public static void init() {
        activityDTO = Injector.injectActivityDTO(ConnectionManager.getConnection());
        statusCode = ConnectionManager.getStatusCode(ConnectionManager.getConnection());
    }

    @Test
    @DisplayName("Test status code")
    public void testStatusCode() {
        Assertions.assertEquals(200, statusCode);
    }

    @Nested
    @DisplayName("Checking the type is correct")
    public class CheckForType {
        @Test
        @DisplayName("Check that the activity is a String")
        public void checkActivityString() {
            Assertions.assertEquals(String.class, activityDTO.getActivity().getClass());
        }
        @Test
        @DisplayName("Check that the price is a Double")
        public void checkThatPriceIsADouble() {
            Assertions.assertEquals(Double.class, activityDTO.getPrice().getClass());
        }

        @Test
        @DisplayName("Check that the number of participants is an Integer")
        void checkThatParticipantsIsAnInteger() {
            Assertions.assertEquals(Integer.class, activityDTO.getParticipants().getClass());
        }

        @Test
        @DisplayName("Check that the number of participants is an Integer second way")
        void checkThatParticipantsIsAnInteger2() {
            Assertions.assertTrue(activityDTO.getParticipants() instanceof Integer);
        }
    }

    @Nested
    @DisplayName("Check the value is correct")
    public class CheckForValue {
        @Test
        @DisplayName("Check that the key is always seven digits")
        public void checkKeyHas7Digits() {
            Assertions.assertTrue(activityDTO.keyHas7Digits());
        }


        @Test
        @DisplayName("Check that activity has at least one participant")
        void checkThatActivityHasAtLeastOneParticipant() {
            Assertions.assertTrue(activityDTO.hasAtLeastOneParticipant());
        }

        @Test
        @DisplayName("Check that activity is not null")
        void checkThatActivityIsNotNull() {
            Assertions.assertNotNull(activityDTO.getActivity());
        }
    }
}
