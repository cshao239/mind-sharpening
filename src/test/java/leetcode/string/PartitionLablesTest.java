package leetcode.string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PartitionLablesTest {

    @ParameterizedTest
    @MethodSource
    public void testCompute(String s, List<String> result) {
        Assertions.assertThat(PartitionLabels.compute(s)).isEqualTo(result);
    }

    private static Stream<Arguments> testCompute(){
        return Stream.of(
                Arguments.of("abdadadafhjfghfgh", Arrays.asList("abdadada","fhjfghfgh")),
                Arguments.of("ababcbacadefegdehijhklij", Arrays.asList("ababcbaca","defegde","hijhklij"))
        );
    }
}
