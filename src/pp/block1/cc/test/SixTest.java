package pp.block1.cc.test;

import org.junit.Test;
import pp.block1.cc.antlr.Six;

public class SixTest {
	private static LexerTester tester = new LexerTester(Six.class);

	@Test
	public void succeedingTest() {
		tester.correct("asdf12");
		tester.correct("s12345d12344");
		tester.yields("a12345a12fg5", Six.WORD, Six.WORD);
		tester.wrong("123456");
	}


	@Test
	public void yieldCountTest() {
		tester.yields("a12345s12345d12345", Six.WORD, Six.WORD, Six.WORD);
	}
}
