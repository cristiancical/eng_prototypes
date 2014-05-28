package com.cristian.engage.action;

import java.util.HashMap;

import javax.naming.OperationNotSupportedException;

public class FacebookAction extends Action {

	public static Source SOURCE_TYPE = Source.FACEBOOK;

	public FacebookAction(OperationType operation, String resourceId,
			HashMap<String, String> params) {
		super();
		this.resourceId = resourceId;
		this.operation = operation;
		this.params = params;
	}
	
	public FacebookAction(OperationType operation, String resourceId,
			String strParams) {
		super();
		this.resourceId = resourceId;
		this.operation = operation;
		this.params = paramDeserialisation(strParams);
	}		
	
	/*
	 * Execute action
	 */
	@Override
	public Object execute() throws OperationNotSupportedException {

		Object result;
		
		switch (operation) {
		// facebook specific actions
		case ADD_COMMENT:
			result = FacebookActionImplementation.sendComment("resource", "text");
			break;
		case LIKE_AS:
			result = FacebookActionImplementation.likeAs("resource", "userId");
			break;
		case SHARE_AS:
			result = FacebookActionImplementation.shareAs("resource", "userId");
			break;
		case SEND_PRIVATE_MESSAGE:
			result = FacebookActionImplementation.sendPrivateMessage("userId", "text");
			break;
		// general actions		
		case ASSIGN_TO:
			result = FacebookActionImplementation.assignTo();
			break;
		case SET_STATUS_AS:
			result = FacebookActionImplementation.setStatusAs();
			break;
		case LINK_TO_CRM:
			result = FacebookActionImplementation.LinkToCRM();
			break;
		case EMAIL_POST_TO:
			result = FacebookActionImplementation.EmailPostTo();
			break;
		case REMOVE_POST:
			result = FacebookActionImplementation.RemovePost();
			break;
		default:
			throw new OperationNotSupportedException("Not supported operation:"
					+ operation);
		}

		return result;

	}

}
