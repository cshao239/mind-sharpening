package leetcode.string;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
public class StrobogrammticTest {

    @ParameterizedTest
    @MethodSource
    public void testCompute(int a, int b, List<Integer> result){
        Assertions.assertThat(Strobogrammtic.compute(a,b)).isEqualTo(result);
    }


    private static Stream<Arguments> testCompute(){
        return Stream.of (
                Arguments.of(50,100, Arrays.asList(88,69,96))
        );
    }
}
