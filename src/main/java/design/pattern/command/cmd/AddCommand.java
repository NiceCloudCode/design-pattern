package design.pattern.command.cmd;

import design.pattern.command.CommandAttachable;
import design.pattern.command.Computable;

/**
 * 加法
 *
 * Create Time: 2019-05-20 10:33
 * Last Modify: 2019-05-20
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class AddCommand implements Command {

    private double x;
    private Computable computable;

    public AddCommand(double x, Computable computable) {
        this.x = x;
        this.computable = computable;
    }

    @Override
    public void calculate() {
        computable.add(x);
        if (computable instanceof CommandAttachable) {
            ((CommandAttachable) computable).attachUndo(this);
        }
    }

    @Override
    public void undo() {
        computable.sub(x);
        if (computable instanceof CommandAttachable) {
            ((CommandAttachable) computable).attachRedo(this);
        }
    }

    @Override
    public void redo() {
        calculate();
    }
}
