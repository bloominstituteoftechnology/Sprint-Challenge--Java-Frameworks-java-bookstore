package com.lambdaschool.bookstore.controller;

import com.lambdaschool.bookstore.model.Role;
import com.lambdaschool.bookstore.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController
{
    @Autowired
    RoleService roleService;

    @GetMapping(value = "/roles", produces = {"application/json"})
    public ResponseEntity<?> listRoles()
    {
        List<Role> allRoles = roleService.findAll();
        return new ResponseEntity<>(allRoles, HttpStatus.OK);
    }


    @GetMapping(value = "/role/{roleId}", produces = {"application/json"})
    public ResponseEntity<?> getRole(@PathVariable Long roleId)
    {
        Role r = roleService.findRoleById(roleId);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }


    @PostMapping(value = "/role")
    public ResponseEntity<?> addNewRole(@Valid @RequestBody Role newRole) throws URISyntaxException
    {
        newRole = roleService.save(newRole);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newRoleURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{roleid}")
                .buildAndExpand(newRole.getRoleid())
                .toUri();
        responseHeaders.setLocation(newRoleURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/role/{roleid}")
    public ResponseEntity<?> updateRole(@RequestBody Role updateRole, @PathVariable long roleid)
    {
        roleService.update(updateRole, roleid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/role/{id}")
    public ResponseEntity<?> deleteRoleById(@PathVariable long id)
    {
        roleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/user/{userid}/role/{roleid}")
    public ResponseEntity<?> addUserRole(@PathVariable long userid, @PathVariable long roleid)
    {
        roleService.saveUserRole(userid, roleid);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/user/{userid}/role/{roleid}")
    public ResponseEntity<?> deleteUserRole(@PathVariable long userid, @PathVariable long roleid)
    {
        roleService.deleteUserRole(userid, roleid);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
