package com.cristian.engage.action;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

/**
 * Represents an macro (group of actions executed together)
 * 
 * @author cristian.cical
 * 
 */
public class Macro {

	/**
	 * Id of the resource (post, tweet, etc) on which the action is applied 
	 */
	private String resourceId;

	/**
	 * Id of the resource (post, tweet, etc) on which the action is applied 
	 */
	private Source resourceSource;
	
	/**
	 * Macro's list of actions 
	 */
	private List<Action> actions = new ArrayList<Action>();

	public Macro(String sourceId, Source resourceSource, List<Action> actions) {
		super();
		this.resourceId = sourceId;
		this.resourceSource = resourceSource;
		if (actions != null) {
			this.actions = actions;
		}
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String sourceId) {
		this.resourceId = sourceId;
	}

	public Source getResourceSource() {
		return resourceSource;
	}

	public void setResourceSource(Source resourceSource) {
		this.resourceSource = resourceSource;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public boolean addAction(Action action) {
		return actions.add(action);
	}

	public void execute() {
		try {
			for (Action action : actions) {
				action.execute();
			}
		} catch (OperationNotSupportedException onse) {
			onse.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Macro [resourceId=" + resourceId + ", resourceSource=" + resourceSource
				+ ", actions=" + actions + "]";
	}
	
}
