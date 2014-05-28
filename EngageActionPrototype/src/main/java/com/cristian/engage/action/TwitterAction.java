package com.cristian.engage.action;

import javax.naming.OperationNotSupportedException;

public class TwitterAction extends Action {

	public static Source SOURCE_TYPE = Source.TWITTER;

	/*
	 * Execute action
	 *
	 */
	@Override
	public Object execute() throws OperationNotSupportedException {
		
		Object result = null;
		
		switch (operation) {
		// twitter specific actions
		case FAVORITE_AS:
			break;
		case REPLY_WITH:
			break;
		case RETWEET_AS:
			break;
		case SEND_DIRECT_MESSAGE:
			break;
		// general actions	
		case ASSIGN_TO:
			result = TwitterActionImplementation.assignTo();
			break;
		case SET_STATUS_AS:
			result = TwitterActionImplementation.setStatusAs();
			break;
		case LINK_TO_CRM:
			result = TwitterActionImplementation.LinkToCRM();
			break;
		case EMAIL_POST_TO:
			result = TwitterActionImplementation.EmailPostTo();
			break;
		case REMOVE_POST:
			result = TwitterActionImplementation.RemovePost();
			break;
			default:
				throw new OperationNotSupportedException("Not supported operation:" + operation);
		}
		
		return result;

	}

}
