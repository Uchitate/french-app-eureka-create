package co.jp.tagbangers.controller.french;

import co.jp.tagbangers.core.model.FrenchCreateRequest;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class FrenchCreateForm implements Serializable {

	@NotNull
	private String name;

	@NotNull
	private String password;

	@Email
	private String email;

	private String address;

	public FrenchCreateRequest toFrenchCreateRequest() {
		FrenchCreateRequest request = new FrenchCreateRequest();
		request.setName(getName());
		request.setPassword(getPassword());
		request.setEmail(getEmail());
		request.setAddress(getAddress());
		return request;
	}
}
