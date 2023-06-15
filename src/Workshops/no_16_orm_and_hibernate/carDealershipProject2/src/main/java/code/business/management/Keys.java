package code.business.management;

import code.infrastructure.database.entity.CarHistoryEntity;

public interface Keys {

    enum InputDataGroup {
        INIT,
        BUY_FIRST_TIME,
        BUY_AGAIN,
        SERVICE_REQUEST,
        DO_THE_SERVICE

    }

    enum Entity {
        SALESMAN,
        MECHANIC,
        CAR,
        SERVICE,
        PART,
        CUSTOMER
    }

    enum Constants {
        WHAT,
        FINISHED
    }
}
