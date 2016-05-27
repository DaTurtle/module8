package pp.block4.cc.iloc;

import org.antlr.v4.runtime.CharStream;
import org.junit.Test;
import pp.iloc.Assembler;
import pp.iloc.Simulator;
import pp.iloc.model.Program;
import pp.iloc.parse.FormatException;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

/**
 * Created by Jan-Willem on 27-5-2016.
 */
public class Testiloc {

    Assembler assembler = Assembler.instance();

    @Test
    public void test() {
        String maxpath = "C:\\Users\\Jan-Willem\\IdeaProjects\\module8\\src\\pp\\block4\\cc\\iloc\\max.iloc";
        Program prog = null;
        try {
            File file = new File(maxpath);
            prog = assembler.assemble(file);
        } catch (FormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String pretty = prog.prettyPrint();
        System.out.println(pretty);
        System.out.println("--------------------------------------------------------------------------");
        Program prog2= null;
        try {
            prog2 = assembler.assemble(pretty);
        } catch (FormatException e) {
            e.printStackTrace();
        }
        String pretty2 = prog2.prettyPrint();
        System.out.println(pretty2);

        assertEquals(prog, prog2);

        Simulator sim = new Simulator(prog);
        sim.getVM().init("a", 1,2,3,4);
        sim.getVM().setNum("alength", 4);
        sim.run();
        assert (sim.getVM().getReg("r_max") == 4);
    }
}
