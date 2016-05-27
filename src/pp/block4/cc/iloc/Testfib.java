package pp.block4.cc.iloc;

import org.junit.Test;
import pp.iloc.Assembler;
import pp.iloc.Simulator;
import pp.iloc.model.Program;
import pp.iloc.parse.FormatException;

import java.io.File;
import java.io.IOException;

/**
 * Created by willem on 5/27/16.
 */
public class Testfib {

    @Test
    public void testfib() {
        Assembler assembler = Assembler.instance();
        String maxpath = "/home/willem/IdeaProjects/antlr/src/pp/block4/cc/iloc/fib.iloc";
        Program prog = null;
        try {
            File file = new File(maxpath);
            System.out.println(file.getAbsolutePath());
            prog = assembler.assemble(file);
        } catch (FormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String pretty = prog.prettyPrint();
        System.out.println(pretty);

        Simulator sim = new Simulator(prog);
        sim.getVM().setNum("n", 10);
        sim.run();
        System.out.println(sim.getVM().getReg("r_z"));
        assert (sim.getVM().getReg("r_z") == 89);
    }
}
