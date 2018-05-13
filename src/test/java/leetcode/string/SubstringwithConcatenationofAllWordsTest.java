package leetcode.string;

import com.google.common.collect.ImmutableList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class SubstringwithConcatenationofAllWordsTest {

    @ParameterizedTest
    @MethodSource
    public void testSubCon(String s, String[] allWords, List<Integer> result) {
        Assertions.assertThat(SubstringwithConcatenationofAllWords.compute(s,allWords)).isEqualTo(result);
    }


    private static Stream<Arguments> testSubCon() {
        return Stream.of(
                Arguments.of("abcdef", new String[]{"def","abc"},ImmutableList.of(0)),
                Arguments.of("543123", new String[]{"123"},ImmutableList.of(3)),
                Arguments.of("ababab", new String[]{"ab"},ImmutableList.of(0,2,4)),
                Arguments.of("ababab", new String[]{"aba"},ImmutableList.of(0,2))
        );
    }
}
