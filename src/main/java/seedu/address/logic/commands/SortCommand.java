package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.COMPARATOR_SORT_NAMES;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Sorts all persons in the address book by name in alphabetical order.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = "Sorts the address book in alphabetical order";

    public static final String MESSAGE_SUCCESS = "Address book sorted in alphabetical order";
    public static final String HELP_SORT_COMMAND = "Sort Command\n"
            + "- Format: sort\n"
            + "- Example: sort";


    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.sortPersonList(COMPARATOR_SORT_NAMES);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}