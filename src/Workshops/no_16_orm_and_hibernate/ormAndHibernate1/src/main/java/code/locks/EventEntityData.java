package code.locks;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class EventEntityData {

    static EventEntity someEvent1() {
        return EventEntity.builder()
                .eventName("StandUp")
                .capacity(5)
                .dateTime(OffsetDateTime.of(2024,10,2, 15,30,0,0, ZoneOffset.ofHours(2)))
                .build();
    }

    static EventEntity someEvent2() {
        return EventEntity.builder()
                .eventName("Koncert")
                .capacity(2)
                .dateTime(OffsetDateTime.of(2025,10,2, 15,30,0,0, ZoneOffset.ofHours(2)))
                .build();
    }
}
