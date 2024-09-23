import org.cruz.processor.service.MakeNew;
import org.cruz.processor.service.TextChange;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TextChangeTest {

    @Mock
    private MakeNew make;

    @InjectMocks
    private TextChange textChange;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    void testMakeTextChangeLower() {
        String input = "JAVA";
        String expected = "java";

        // Mock the make.makeLowerText behavior
        when(make.makeLowerText(input)).thenReturn(expected);

        // Act
        String result = textChange.makeTextChangeLower(input);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testMakeTextChangeUpper() {
        // Arrange
        String input = "java";
        String expected = "JAVA";

        // Mock the make.makeUpperText behavior
        when(make.makeUpperText(input)).thenReturn(expected);

        // Act
        String result = textChange.makeTextChangeUpper(input);

        // Assert
        assertEquals(expected, result);
    }
}
