package Patterns.Structural.Facade;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarFactoryFacade {

    private FrameAssembler frameAssembler;
    private Painter painter;
    private EngineMaker engineMaker;
    private CockpitAssembler cockpitAssembler;
    private DoorMaker doorMaker;
    private SeatsMaker seatsMaker;
    private WheelsProducer wheelsProducer;

    public void produceCar() {
        frameAssembler.assembleFrame();
        painter.paintSkeleton();
        engineMaker.fastenEngine();
        cockpitAssembler.mountCockpit();
        doorMaker.installDoor();
        seatsMaker.attachSeats();
        wheelsProducer.attachWheels();
    }
}
