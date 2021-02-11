package br.com.zup.CriacaoDePropostas.controller.validacao;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.CriacaoDePropostas.controller.request.PropostarRequest;

public class DocumentoValidacao implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PropostarRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {

		}
		PropostarRequest request = (PropostarRequest) target;
		if (!request.documentoValido()) {
			errors.rejectValue("documento", null, "Documento precisa ser cpf ou cnpj");
		}
	}
}
