package pp.block1.cc.test;

import org.junit.Test;
import pp.block1.cc.antlr.Example;
import pp.block1.cc.antlr.PL1;

public class PL1Test {
	private static LexerTester tester = new LexerTester(PL1.class);

	@Test
	public void succeedingTest() {
		tester.correct("\"beep\"");
		tester.correct("\"hi my name is \"\"bert\"\" lol \"");
		tester.wrong("\" hello \" asd\"");
	}
}
