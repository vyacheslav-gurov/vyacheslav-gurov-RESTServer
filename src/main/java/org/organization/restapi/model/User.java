package org.organization.restapi.model;

import javax.persistence.*;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"email"})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String email;
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> roles = new HashSet<>();

	public void addRoles(Role role) {
		roles.add(role);
		role.getUsers().add(this);
	}

	public void setRoles(Role role) {
		roles.remove(role);
		role.getUsers().remove(this);
	}

	public String get_id() { return this.id.toString(); }

	public void setPassword(String password) { this.password = password; }

	public String getPassword() { return password; }

	public void setUsername(String username) { this.username = username; }

	public String getUsername() { return username; }
}
