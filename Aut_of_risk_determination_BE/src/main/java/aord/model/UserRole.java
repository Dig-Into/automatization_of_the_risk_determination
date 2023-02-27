package aord.model;

import javax.persistence.*;

import aord.model.enums.UserRoleName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_role", indexes = { @Index(columnList = "name", unique = true, name = "user_role_uk_on_name"), })
public class UserRole {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private UserRoleName name;
}
