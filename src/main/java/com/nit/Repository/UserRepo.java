package com.nit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.UserData;
import java.util.List;


public interface UserRepo extends JpaRepository<UserData, Integer>
{
	UserData findByMailId(String mailId);
	UserData findByMailIdAndPassword(String mailId,String password);

}
