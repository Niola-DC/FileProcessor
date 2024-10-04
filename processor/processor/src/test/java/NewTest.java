import org.cruz.processor.service.TextChange;
import org.easymock.IExpectationSetters;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class NewTest {

    TextChange tc = mock(TextChange.class);  //Initializing our mock

    @Test
    public void mockDiss() {
        String expected = expect(tc.makeTextChangeLower("JAVA")).andReturn("java").toString();

        replay(tc);

        verify(tc);
    }
}
