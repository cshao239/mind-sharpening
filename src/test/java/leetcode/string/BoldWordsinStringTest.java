package leetcode.string;

import com.google.common.collect.ImmutableSet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class BoldWordsinStringTest {



    @ParameterizedTest
    @MethodSource
    public void testCompute(String s, Set<String> words, String result) {
        Assertions.assertThat(BoldWordsinString.compute(s, words)).isEqualTo(result);
    }

    private static Stream<Arguments> testCompute(){
        return Stream.of(
                Arguments.of("aabcd", ImmutableSet.of("ab","bc"),"a<b>abc</b>d"),
                Arguments.of("badadfadsbadsads", ImmutableSet.of("ad","sa"),"b<b>adad</b>f<b>ad</b>sb<b>adsad</b>s")
        );
    }
}
