package com.cristian.engage.action;

public class TwitterActionImplementation {
	
	public static String likeAs(String resourceId, String userId) {
		System.out.println(String.format("Dummy action: Like resource %s as:%s", resourceId, userId));
		return "message";
	}

	public static String shareAs(String resourceId, String userId) {
		System.out.println(String.format("Dummy action: Share resource %s by :%s", resourceId, userId));
		return "message";
	}
	
	public static String sendPrivateMessage(String userId, String message) {
		System.out.println(String.format("Dummy action: Send message %s to resource:%s", message, userId));
		return "message";
	}
	
	public static String assignTo() {
		System.out.println(String.format("Dummy action: Assign to"));
		return "message";
	}

	public static String setStatusAs() {
		System.out.println(String.format("Dummy action: SET STATUS AS"));
		return "message";
	}
	
	public static String LinkToCRM() {
		System.out.println(String.format("Dummy action: Link To CRM"));
		return "message";
	}
	
	public static String EmailPostTo() {
		System.out.println(String.format("Dummy action: Email Post To"));
		return "message";
	}
	
	public static String RemovePost() {
		System.out.println(String.format("Dummy action: Remove post"));
		return "message";
	}	
	
}
