	package com.mobile.controller;
	
	import java.time.LocalDate;
	import java.util.List;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	
	import com.mobile.entity.Assignment;
	import com.mobile.entity.Executive;
	import com.mobile.entity.Phone;
	import com.mobile.entity.WaitingList;
	import com.mobile.repository.AssignmentRepository;
	import com.mobile.repository.ExecutiveRepository;
	import com.mobile.repository.PhoneRepository;
	import com.mobile.repository.WaitingListRepository;
	
	@Controller
	@RequestMapping("/assignments")
	public class AssignmentController {
	
	    @Autowired
	    private ExecutiveRepository executiveRepository;
	
	    @Autowired
	    private PhoneRepository phoneRepository;
	
	    @Autowired
	    private AssignmentRepository assignmentRepository;
	    
	    @Autowired
	    private WaitingListRepository waitingListRepository;
	
	    @GetMapping
	    public String assignments(Model model) {
	        model.addAttribute("assignments", assignmentRepository.findAll());
	        return "assignments";
	    }
	
	    @GetMapping("/assign")
	    public String assignPhones() {
	
	
	        List<Executive> executives =
	                executiveRepository.findByPresentStatus("Present");
	
	
	        List<Phone> availablePhones =
	                phoneRepository.findByStatus("Available");
	
	
	
	        for (Executive executive : executives) {
	
	
	            // Check phone availability
	
	            if (availablePhones.isEmpty()) {
	
	
	                WaitingList waiting = new WaitingList();
	
	
	                waiting.setExecutive(executive);
	
	                waiting.setWaitingDate(LocalDate.now());
	
	                waiting.setReason("No phone available");
	
	
	                waitingListRepository.save(waiting);
	
	
	                continue;
	            }
	
	
	
	            // Take first available phone
	
	            Phone phone = availablePhones.get(0);
	
	
	
	            // Change phone status
	
	            phone.setStatus("Assigned");
	
	            phoneRepository.save(phone);
	
	
	
	            // Create assignment
	
	            Assignment assignment = new Assignment();
	
	
	            assignment.setExecutive(executive);
	
	            assignment.setPhone(phone);
	
	            assignment.setAssignedDate(LocalDate.now());
	
	            assignment.setStatus("Assigned");
	
	
	            assignmentRepository.save(assignment);
	
	
	
	            // Remove assigned phone from available list
	
	            availablePhones.remove(phone);
	
	        }
	
	
	        return "redirect:/assignments";
	    }
	    
	    @GetMapping("/return/{id}")
	    public String returnPhone(@PathVariable Long id) {
	
	        Assignment assignment =
	                assignmentRepository.findById(id).orElse(null);
	
	        if (assignment != null) {
	
	            assignment.setReturnDate(LocalDate.now());
	            assignment.setStatus("Returned");
	
	            Phone phone = assignment.getPhone();
	            phone.setStatus("Available");
	
	            phoneRepository.save(phone);
	            assignmentRepository.save(assignment);
	        }
	
	        return "redirect:/assignments";
	    }
	
	    @GetMapping("/history")
	    public String showHistory(Model model) {
	
	        List<Assignment> history = assignmentRepository.findAll();
	
	        model.addAttribute("history", history);
	
	        return "history";
	    }
	    
	    @GetMapping("/waiting")
	    public String waitingList(Model model) {
	
	        model.addAttribute(
	                "waitingList",
	                waitingListRepository.findAll()
	        );
	
	        return "waiting";
	    }
	    
	    @GetMapping("/assign-form")
	    public String assignForm(Model model) {
	
	        List<Executive> executives =
	                executiveRepository.findByPresentStatus("Present");
	
	        List<Phone> phones =
	                phoneRepository.findByStatus("Available");
	
	        model.addAttribute("executives", executives);
	        model.addAttribute("phones", phones);
	
	        return "assign-phone";
	    }
	    
	    @PostMapping("/save")
	    public String saveAssignment(
	            @RequestParam Long executiveId,
	            @RequestParam Long phoneId) {
	
	
	        Executive executive =
	                executiveRepository.findById(executiveId).get();
	
	
	        Phone phone =
	                phoneRepository.findById(phoneId).get();
	
	
	
	        phone.setStatus("Assigned");
	
	        phoneRepository.save(phone);
	
	
	
	        Assignment assignment = new Assignment();
	
	        assignment.setExecutive(executive);
	
	        assignment.setPhone(phone);
	
	        assignment.setAssignedDate(LocalDate.now());
	
	        assignment.setStatus("Assigned");
	
	
	        assignmentRepository.save(assignment);
	
	
	
	        return "redirect:/assignments";
	
	    }
	    
	    @GetMapping("/manual-assign")
	    public String manualAssign(Model model) {


	        model.addAttribute(
	                "executives",
	                executiveRepository.findByPresentStatus("Present")
	        );


	        model.addAttribute(
	                "phones",
	                phoneRepository.findByStatus("Available")
	        );


	        return "manual-assign";
	    }
	    
	    @PostMapping("/manual-save")
	    public String saveManualAssignment(
	            @RequestParam Long executiveId,
	            @RequestParam Long phoneId) {


	        Executive executive =
	                executiveRepository.findById(executiveId)
	                .orElse(null);


	        Phone phone =
	                phoneRepository.findById(phoneId)
	                .orElse(null);



	        if(phone != null && phone.getStatus().equals("Available")) {


	            phone.setStatus("Assigned");

	            phoneRepository.save(phone);



	            Assignment assignment = new Assignment();


	            assignment.setExecutive(executive);

	            assignment.setPhone(phone);

	            assignment.setAssignedDate(LocalDate.now());

	            assignment.setStatus("Assigned");


	            assignmentRepository.save(assignment);

	        }


	        return "redirect:/assignments";
	    }
	    
	    
	    
	
	}