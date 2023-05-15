package code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;
//@ExtendWith do oznaczenia że używa Mockito
@ExtendWith(MockitoExtension.class)
class StaticMethodExampleTest {
    @Spy
    private StaticMethodExample staticMethodExample = new StaticMethodExample();

    @Test
    void testGetNano() {
        //given
        LocalTime now = LocalTime.now();
        int nanoNow = now.getNano();
        LocalTime nowEarlier = now.minusNanos(100);
        int nanoEarlier = nowEarlier.getNano();
        Mockito.when(staticMethodExample.getNow()).thenReturn(nowEarlier);

        //when
       // int result = staticMethodExample.getNano();

        // można użyć też z pomocą mockito-inline innego sposobu - wtedy nie trzeba używać @ExtendWith i @Spy
        int result;
        try (MockedStatic<LocalTime> timeMock = Mockito.mockStatic(LocalTime.class)) {
            timeMock.when(LocalTime::now).thenReturn(nowEarlier);
            // when
            result = staticMethodExample.getNano();
        }
        //then
        Assertions.assertNotEquals(result, nanoNow);
        Assertions.assertEquals(result, nanoEarlier);
    }
}