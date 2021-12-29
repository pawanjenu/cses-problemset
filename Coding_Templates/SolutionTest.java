import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("generateData")
    public void testParameters(int[] nums, int target, int[] output) {
//        int[] result = new Solution().twoSum(nums, target);
//        Arrays.sort(result);
//        Arrays.sort(output);
//        assertArrayEquals(result, output);
    }
    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1})
        );
    }
}
