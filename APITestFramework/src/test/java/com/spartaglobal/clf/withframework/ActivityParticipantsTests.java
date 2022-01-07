package com.spartaglobal.clf.withframework;

import com.spartaglobal.clf.withframework.connection.ConnectionManager;
import com.spartaglobal.clf.withframework.dto.ActivityDTO;
import com.spartaglobal.clf.withframework.injector.Injector;
import org.junit.jupiter.api.*;

public class ActivityParticipantsTests {
    private static ActivityDTO activityDTO;

    @BeforeAll
    public static void init() {
        activityDTO = Injector.injectActivityDTO(ConnectionManager.getConnectionForGivenNumberOfParticipants(3));
    }

    @Test
    @DisplayName("Number of participants is correct")
    public void testParticipantNumber() {
        Assertions.assertEquals(3, activityDTO.getParticipants());
    }
}
