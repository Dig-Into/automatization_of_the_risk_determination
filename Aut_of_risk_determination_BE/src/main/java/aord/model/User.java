package aord.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@SuppressWarnings("serial")
@Entity(name = "User")
@Table(indexes = @Index(columnList = "email", unique = true, name = "user_uk_on_email"))
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String email;
	private String password;

	@JoinColumn(name = "user_role_id", foreignKey = @ForeignKey(name = "user_fk_on_user_role"))
	@ManyToOne
	private UserRole userRole;

}
