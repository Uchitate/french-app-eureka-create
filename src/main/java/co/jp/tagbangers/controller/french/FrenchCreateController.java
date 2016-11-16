package co.jp.tagbangers.controller.french;

import co.jp.tagbangers.core.entity.French;
import co.jp.tagbangers.core.service.FrenchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static java.util.Optional.ofNullable;

@Controller
@RequestMapping("/frenches/new")
public class FrenchCreateController {

	public static final String FORM_MODEL_KEY = "form";

	public static final String ERRORS_MODEL_KEYS = BindingResult.MODEL_KEY_PREFIX + FORM_MODEL_KEY;

	@Autowired
	FrenchService frenchService;

	@GetMapping
	public String input(Model model) {
		FrenchCreateForm form = (FrenchCreateForm) model.asMap().get(FORM_MODEL_KEY);
		form = ofNullable(form).orElse(new FrenchCreateForm());
		model.addAttribute("form", form);
		return "french/create";
	}

	@PostMapping
	public String save(
			@Validated @ModelAttribute(FORM_MODEL_KEY) FrenchCreateForm form,
			BindingResult errors,
			RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute(FORM_MODEL_KEY, form);
		redirectAttributes.addFlashAttribute(ERRORS_MODEL_KEYS, errors);
		if (errors.hasErrors()) {
			return "redirect:/frenches/new?error";
		}
		French savedFrench = frenchService.create(form.toFrenchCreateRequest());
		redirectAttributes.getFlashAttributes().clear();
		redirectAttributes.addFlashAttribute("savedFrench", savedFrench);

		return "redirect:/frenches";
	}
}
