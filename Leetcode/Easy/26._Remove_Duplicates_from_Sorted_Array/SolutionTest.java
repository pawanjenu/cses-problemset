import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("generateData")
    public void testSolution(int[] nums, int output) {
        int result = new Solution().removeDuplicates(nums);
        assertSame(result, output);
    }
    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(new int[]{0,0,1,1,1,2,2,3,3,4}, 5)
        );
    }
}
