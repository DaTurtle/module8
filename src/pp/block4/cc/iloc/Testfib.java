package pp.block4.cc.iloc;

import org.junit.Test;
import pp.iloc.Assembler;
import pp.iloc.Simulator;
import pp.iloc.model.Program;
import pp.iloc.parse.FormatException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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

        ArrayList<Integer> vallist = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Simulator sim = new Simulator(prog);
            sim.getVM().setNum("n", i);
            sim.run();
            System.out.println(sim.getVM().getReg("r_z"));
            vallist.add(i, sim.getVM().getReg("r_z"));
        }

        String fibpath = "/home/willem/IdeaProjects/antlr/src/pp/block4/cc/iloc/fib.iloc";
        Program prog2 = null;
        try {
            File file = new File(fibpath);
            System.out.println(file.getAbsolutePath());
            prog2 = assembler.assemble(file);
        } catch (FormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String pretty2 = prog.prettyPrint();
        System.out.println(pretty2);

        for (int i = 0; i < 15; i++) {
            Simulator sim = new Simulator(prog2);
            sim.getVM().setNum("n", i);
            sim.run();
            System.out.println(sim.getVM().getReg("r_z"));
            assert sim.getVM().getReg("r_z") == vallist.get(i);
        }
    }
}
