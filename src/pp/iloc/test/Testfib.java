package pp.iloc.test;

import org.junit.Test;
import pp.iloc.Assembler;
import pp.iloc.Simulator;
import pp.iloc.model.Program;
import pp.iloc.parse.FormatException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
        String maxpath = "C:\\Users\\Jan-Willem\\IdeaProjects\\module8\\src\\pp\\block6\\cc\\fib.iloc";
        Program prog = null;
        try {
            File file = new File(maxpath);
            System.out.println(file.getAbsolutePath());
            prog = assembler.assemble(file);
        } catch (FormatException | IOException e) {
            e.printStackTrace();
        }
        String pretty = prog.prettyPrint();
        System.out.println(pretty);


        for (int i = 0; i < 15; i++) {
            Simulator sim = new Simulator(prog);
            String num = ""+i;
            sim.setIn(new ByteArrayInputStream(num.getBytes()));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            sim.setOut(out);
            sim.run();
            String res = out.toString();
            System.out.println(res);
        }
    }
}
