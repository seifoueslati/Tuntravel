package com.ensat.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ensat.entities.Bagage;
import com.ensat.services.BagageService;
import com.ensat.services.EmailService;
/*
import com.ssdi.Create;
import com.ssdi.entity.Plan;
import com.ssdi.entity.User;
import com.ssdi.service.EmailService;
import com.ssdi.service.PlanService;
import com.ssdi.service.UserService;
/*
import com.ssdi.Create;
import com.ssdi.entity.Plan;
import com.ssdi.entity.User;
import com.ssdi.service.EmailService;
import com.ssdi.service.PlanService;
import com.ssdi.service.UserService;
*/
@RestController
public class SendEmailController {

	EmailService emailService;
	// PlanService planService;
	// UserService userService;

	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(PlanController.class);

	@Autowired
	public SendEmailController(EmailService emailService) {
		super();
		this.emailService = emailService;
		// this.planService = planService;

	}

	public SendEmailController() {

	}

	@Autowired
	BagageService bagageService;
	
}
