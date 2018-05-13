package leetcode.string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LetterCasePermutationTest {

    @ParameterizedTest
    @MethodSource
    public void testCompute(String s, List<String> result) {
        Assertions.assertThat (LetterCasePermutation.compute(s)).isEqualTo(result);
        //Assertions.assertThat (LetterCasePermutation.compute2(s)).isEqualTo(result);
    }



    private static Stream<Arguments> testCompute() {
        return Stream.of(
                Arguments.of("ab",Arrays.asList("ab","Ab","aB","AB")),
                Arguments.of("ab1c",Arrays.asList("ab1c","Ab1c","aB1c","AB1c","ab1C","Ab1C","aB1C","AB1C"))
        );
    }
}
