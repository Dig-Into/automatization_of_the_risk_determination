package aord.model;

import java.time.Instant;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "JWT")
@Table(indexes = @Index(columnList = "value", unique = true, name = "jwt_uk_on_value"))
public class JWT {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 2048)
	private String value;

	private Instant expirationTime;

	@JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "jwt_fk_on_user"))
	@ManyToOne
	private User user;
}
