package com.springboot.restapi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restapi.entity.Entry;

@RestController
@RequestMapping("/journal")
public class EntryController {

	private Map<Long , Entry> entries = new HashMap<>();
	
	@GetMapping
	public List<Entry> getAll()
	{
		return new ArrayList<>(entries.values());
		
	}
	
	@PostMapping
	public boolean createEntry(@RequestBody Entry myEntry)
	{
		entries.put(myEntry.getId(), myEntry);
		return true;
	}
	
	@GetMapping("id/{myid}")
	public Entry getById(@PathVariable Long myid)
	{
		return entries.get(myid);
		
	}
	
	@DeleteMapping
	public Entry deleteById(@PathVariable Long myid)
	{
		return entries.remove(myid);
	}
	
	@PutMapping("id/{id}")
	public Entry updateById(@PathVariable Long id, @RequestBody Entry myEntry)
	{
		return entries.put(id, myEntry);
	}
}
