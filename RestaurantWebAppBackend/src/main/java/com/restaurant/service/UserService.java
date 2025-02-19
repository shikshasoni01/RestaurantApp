package com.restaurant.service;




import com.restaurant.DTO.UserDTO;
import com.restaurant.entity.RoleType;
import com.restaurant.entity.User;
import com.restaurant.entity.UserLoggedIn;
import com.restaurant.exception.RestaurantException;

import com.restaurant.repository.RoleRepository;
import com.restaurant.repository.UserLoggedRepository;
import com.restaurant.repository.UserRepository;
import com.restaurant.requestwrapper.UserLoginRequestWrapper;
import com.restaurant.requestwrapper.UserRequestWrapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService  {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserLoggedRepository userLoggedRepository;


    public void createUser(UserRequestWrapper request) throws RestaurantException
    {
        Optional<User> user= userRepository.findByEmailIgnoreCase(request.getEmail());
        User newUser= new User();
        RoleType role= roleRepository.findByRole(request.getRole());

        if (user.isEmpty())
        {
            newUser.setFullName(request.getFullName());
            newUser.setEmail(request.getEmail());
            newUser.setPassword(request.getPassword());
            if(role!=null)
            {
                newUser.setRole(role);
            }
            else {
                throw new RestaurantException("Role not exist",400);
            }
            userRepository.save(newUser);
        }
        else
        {
            throw new RestaurantException("User already exist",400);
        }
    }
    public UserDTO getUserLogged() throws RestaurantException
    {
        List<UserLoggedIn> userLoggedIn= userLoggedRepository.findAll();
        System.out.println(userLoggedIn);
        UserDTO userDTO= new UserDTO();
        for (UserLoggedIn user:userLoggedIn){

            userDTO.setUserId(user.getUser().getId());
            userDTO.setName(user.getUser().getFullName());
            userDTO.setEmail(user.getUser().getEmail());
            userDTO.setRoleId(user.getUser().getRole().getId());
            userDTO.setRoleType(user.getUser().getRole().getRole());
        }
        return userDTO;
    }

    public boolean login(UserLoginRequestWrapper userLoginRequestWrapper) throws RestaurantException
    {
        Optional<User> user= userRepository.findByEmailIgnoreCase(userLoginRequestWrapper.getEmail());



        if (user.isPresent())
        {
           if (user.get().getPassword().equals(userLoginRequestWrapper.getPassword())) {
               userLoggedRepository.deleteAll();
               UserLoggedIn newUserLogged= new UserLoggedIn();
               newUserLogged.setUser(user.get());
               userLoggedRepository.save(newUserLogged);
               return true;
           }
           else {
               throw new RestaurantException("Password not match",400);
           }
        }

        return false;
    }

}
