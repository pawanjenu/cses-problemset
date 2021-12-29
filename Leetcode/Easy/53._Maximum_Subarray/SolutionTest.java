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
    public void testSolution(int[] nums,  int output) {
        int result = new Solution().maxSubArray(nums);
        assertSame(output, result);
    }
    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(new int[]{-2,1,-3,4,-1,2,1,-5,4}, 6)
        );
    }
}
