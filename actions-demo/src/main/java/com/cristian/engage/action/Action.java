package com.cristian.engage.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.naming.OperationNotSupportedException;

/**
 * Represents an action of the type "OperationType"
 * 
 * @author cristian.cical
 * 
 */
public abstract class Action {

	/**
	 * Represents all user actions that can be executed on source (facebook, tweeter, etc.) resources
	 * 
	 */
	public enum OperationType {
		ASSIGN_TO(Source.ALL), SET_STATUS_AS(Source.ALL), LINK_TO_CRM(Source.ALL), EMAIL_POST_TO(Source.ALL), REMOVE_POST(
				Source.ALL), ADD_COMMENT(Source.FACEBOOK), LIKE_AS(Source.FACEBOOK), SHARE_AS(Source.FACEBOOK), SEND_PRIVATE_MESSAGE(
				Source.FACEBOOK), REPLY_WITH(Source.TWITTER), RETWEET_AS(Source.TWITTER), FAVORITE_AS(Source.TWITTER), SEND_DIRECT_MESSAGE(
				Source.TWITTER);

		private final Source source;

		OperationType(Source source) {
			this.source = source;
		}

		public Source getSource() {
			return source;
		}

		public static List<OperationType> getSourceActions(Source source) {
			List<OperationType> otList = new ArrayList<OperationType>();
			for (OperationType ot : OperationType.values()) {
				if (ot.getSource().equals(source)) {
					otList.add(ot);
				}
			}
			return otList;
		}
	}

	/**
	 * Id of the resource (post, tweet, etc) on which the action is applied 
	 */
	String resourceId;

	/**
	 * Operation type (Facebook like, Tweeter retweet, etc.) 
	 */	
	OperationType operation;
	
	/**
	 * Fixed parameters specific to operation  
	 */		
	HashMap<String, String> params;

	public Action() {

	}

	public String getResourceId() {
		return resourceId;
	}
	
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public OperationType getOperation() {
		return operation;
	}

	public void setOperation(OperationType operation) {
		this.operation = operation;
	}

	public HashMap<String, String> getParams() {
		return params;
	}

	public void setParams(HashMap<String, String> params) {
		this.params = params;
	}

	public abstract Object execute() throws OperationNotSupportedException;

	public static HashMap<String, String> paramDeserialisation(String paramsList) {
		return new HashMap<String, String>();
	}

	@Override
	public String toString() {
		return "Action [resourceId=" + resourceId + ", operation=" + operation
				+ ", params=" + params + "]";
	}

}
