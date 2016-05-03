package pp.block1.cc.test;

import org.junit.Test;
import pp.block1.cc.antlr.Lala;

public class LalaTest {

	private static LexerTester tester = new LexerTester(Lala.class);

	@Test
	public void succeedingTest() {
		tester.correct("La");
		tester.correct("Laa");
		tester.correct("La ");
		tester.correct("LaLa");
		tester.correct("La La");
		tester.correct("Laa  La");
		tester.correct("LaLaLaLi");
		tester.correct("LaaaaaLaLaaaLi");

	}

    @Test
    public void yieldTest() {
        tester.yields("La   La LaaaLaLaaLiLaaaaa    La La", Lala.LA, Lala.LA, Lala.LALALALI, Lala.LA);

    }

	@Test
	public void failingTest(){
		tester.wrong("LL");
		tester.wrong("La a");
		tester.wrong("LaLaLi");
	}
}