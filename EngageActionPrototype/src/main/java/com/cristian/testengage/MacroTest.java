package com.cristian.testengage;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cristian.engage.action.Action;
import com.cristian.engage.action.Action.OperationType;
import com.cristian.engage.action.FacebookAction;
import com.cristian.engage.action.Macro;
import com.cristian.engage.action.Source;
import com.cristian.engage.entities.ActionEntity;
import com.cristian.engage.entities.EntityManagerSource;
import com.cristian.engage.entities.MacroEntity;
import com.cristian.engage.entities.MacroEntityDAO;

public class MacroTest {

	private static String RESOURCE_ID = "111";
	private static Source RESOURCE_SOURCE = Source.FACEBOOK;
	
	@BeforeClass
	public static void setup() {
		// init entity manager (to have the initialization messages at the beginning of the test log) 
		EntityManagerSource.INSTANCE.getEntityManager();
	}
	
	@AfterClass
	public static void tearDown() {
		EntityManagerSource.INSTANCE.closeEntityManager();
	}

	@Test
	public void testMacro() {

		System.out.print("1. DISPLAY OPERATION LIST:\n\n");
		displayOp(getOp());

		System.out.print("\n\n2. CREATE MACRO ENTITY AND PERSIST IT TO Database:\n\n");
		com.cristian.engage.entities.MacroEntity macroEntity = createMacroEntity();

		System.out.print("\n\n3. LOAD MACRO EXECUTOR FROM DATABASE:\n\n");
		Macro macro = loadMacro(macroEntity.getId());

		System.out.println(String.format("\n\n4. EXECUTE MACRO ACTIONS ON resource with id: %s from source %s:\n\n", RESOURCE_ID,
				RESOURCE_SOURCE));
		macro.execute();

	}

	private MacroEntity createMacroEntity() {
		String macroName = "Macro name on " + new GregorianCalendar().getTime().toString();

		List<ActionEntity> actionsList = new ArrayList<ActionEntity>();
		actionsList.add(createFirstAction());
		actionsList.add(createSecondAction());
		actionsList.add(createThirdAction());
		MacroEntity macro = new MacroEntity(macroName, actionsList);
		MacroEntityDAO.persist(macro);

		System.out.println("Created & saved macro: " + macro + " with id:" + macro.getId());
		return macro;
	}

	private ActionEntity createFirstAction() {
		String selectedOperation = OperationType.ADD_COMMENT.name();
		String messageText = "Test message";

		ActionEntity action = new ActionEntity(selectedOperation, String.format("{message:%s}", messageText));

		System.out.println("Created action: " + action);
		return action;
	}

	private ActionEntity createSecondAction() {
		String selectedOperation = OperationType.SHARE_AS.name();

		ActionEntity action = new ActionEntity(selectedOperation, "{}");

		System.out.println("Created action: " + action);
		return action;
	}

	private ActionEntity createThirdAction() {
		String selectedOperation = OperationType.EMAIL_POST_TO.name();
		String email = "testemail@outlook.com";

		ActionEntity action = new ActionEntity(selectedOperation, String.format("{email:%s}", email));

		System.out.println("Created action: " + action);
		return action;
	}

	private Macro loadMacro(int macroId) {

		System.out.println("Load macro entity from db");
		MacroEntity macroEntity = MacroEntityDAO.findById(macroId);
		System.out.println("Loaded entity macro: " + macroEntity.toString());

		System.out.println("Load macro executor from macro entity");
		List<Action> actionsList = new ArrayList<Action>();

		if (macroEntity.getActions() != null) {
			for (ActionEntity act : macroEntity.getActions()) {
				HashMap<String, String> params = Action.paramDeserialisation(act.getParams());
				if (RESOURCE_SOURCE.equals(Source.FACEBOOK)) {
					actionsList.add(new FacebookAction(OperationType.valueOf(act.getOperation()), RESOURCE_ID, params));
				}
			}
		}

		Macro macro = new Macro(RESOURCE_ID, RESOURCE_SOURCE, actionsList);
		System.out.println("Loaded execution macro: " + macro.toString());

		return macro;
	}

	private List<OperationType> getOp() {
		List<OperationType> operations = OperationType.getSourceActions(Source.ALL);
		operations.addAll(OperationType.getSourceActions(Source.FACEBOOK));
		operations.addAll(OperationType.getSourceActions(Source.TWITTER));

		return operations;
	}

	private void displayOp(List<OperationType> operations) {
		for (int i = 0; i < operations.size(); i++)
			System.out.println(String.format("%d.%s (%s)", (i + 1), operations.get(i).name(), operations.get(i)
					.getSource().name()));
	}

}
