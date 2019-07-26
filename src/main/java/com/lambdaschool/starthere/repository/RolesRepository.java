package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.Role;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface RolesRepository extends CrudRepository<Role, Long>
{
@Transactional
@Modifying
@Query(value = "DELETE from UserRole where userid = :userid")
    void deleteUserRolesByUserId(long userid);

@Transactional
@Modifying
@Query(value = "INSERT INTO UserRole(userid, roleid) values (:userid, :roleid)",
       nativeQuery = true)
    void insertUserRoles(long userid, long roleid);

            Role findByNameIgnoreCase(String name);
            }