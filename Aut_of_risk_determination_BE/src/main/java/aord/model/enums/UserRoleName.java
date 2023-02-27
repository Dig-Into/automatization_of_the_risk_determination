package aord.model.enums;

import java.util.Arrays;
import java.util.List;

public enum UserRoleName {
	ROLE_ADMIN("ROLE_ADMIN"), ROLE_USER("ROLE_USER");

	private final String text;

	UserRoleName(final String text) {
		this.text = text;
	}

	public static List<UserRoleName> getAdminRoleNames() { // TODO: Required?
		return Arrays.asList(ROLE_ADMIN);
	}

	@Override
	public String toString() {
		return text;
	}
}
