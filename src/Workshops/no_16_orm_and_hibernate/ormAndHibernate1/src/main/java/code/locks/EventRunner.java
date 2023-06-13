package code.locks;

public class EventRunner {

    public static void main(String[] args) {
        EventRepository eventRepository = new EventRepository();
        eventRepository.deleteAll();

        EventEntity event1 = eventRepository.createEmptyEvent(EventEntityData.someEvent1());
        EventEntity event2 = eventRepository.createEmptyEvent(EventEntityData.someEvent2());

        eventRepository.saveNewTicket("Karol", "zajavka", event1.getEventId());
        eventRepository.saveNewTicket("Anna", "Maciejewska", event2.getEventId());

        //concurrency code
    }
}
