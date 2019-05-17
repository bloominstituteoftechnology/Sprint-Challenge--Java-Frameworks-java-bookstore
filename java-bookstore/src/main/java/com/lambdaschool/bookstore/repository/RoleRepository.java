package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.model.Role;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface RoleRepository extends CrudRepository<Role, Long>
{
    @Transactional
    @Modifying
    @Query(value = "DELETE from UserRoles where userid = :userid")
    void deleteUserRolesByUserId(long userid);

    @Transactional
    @Modifying
    @Query(value = "DELETE from UserRoles where roleid = :roleid")
    void deleteUserRolesByRoleId(long roleid);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO UserRoles(userid, roleid) values (:userid, :roleid)", nativeQuery = true)
    void insertUserRoles(long userid, long roleid);

    @Transactional
    @Modifying
    @Query(value = "DELETE from UserRoles where userid = :userid AND roleid = :roleid", nativeQuery = true)
    void deleteUserRoles(long userid, long roleid);
}
