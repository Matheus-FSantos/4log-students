package io.github.matheusfsantos.model.service;

import io.github.matheusfsantos.model.domain.Users;
import io.github.matheusfsantos.model.dto.UsersDTO;
import io.github.matheusfsantos.model.dto.ViaCepDTO;
import io.github.matheusfsantos.model.exception.AppErrors;
import io.github.matheusfsantos.model.exception.specialization.AddressNotFound;
import io.github.matheusfsantos.model.exception.specialization.InvalidFields;
import io.github.matheusfsantos.model.exception.specialization.UserNotFound;
import io.github.matheusfsantos.model.feign.ViaCepService;
import io.github.matheusfsantos.model.repository.UsersRepository;
import io.github.matheusfsantos.model.validation.UsersValidation;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ViaCepService viaCepService;

    public List<UsersDTO> findAll() throws UserNotFound, AddressNotFound { /* checked */
        List<Users> usersList = this.usersRepository.findAll();
        List<UsersDTO> usersDTOList = new ArrayList<>();

        if(usersList.isEmpty())
            throw new UserNotFound(HttpStatus.NOT_FOUND, "Empty database!", "The method to search all users was invoked, but no one was found!");

        for(Users user : usersList) {
            ViaCepDTO viaCepDTO = this.viaCepService.getAddress(user.getCEP());

            if(viaCepDTO.getLocalidade() == null || viaCepDTO.getUf() == null)
                throw new AddressNotFound(HttpStatus.NOT_FOUND, "Address Not Found", "The method to look up an address was called, but the address passed is invalid!");

            usersDTOList.add(new UsersDTO(user, viaCepDTO));
        }

        return usersDTOList;
    }

    public UsersDTO findById(String ra) throws UserNotFound, AddressNotFound { /* checked */
        Optional<Users> user = this.usersRepository.findById(ra);

        if(user.isEmpty())
            throw new UserNotFound(HttpStatus.NOT_FOUND, "User not found in database!", "The method to search for a user was invoked, but it was not found!");

        ViaCepDTO viaCepDTO = this.viaCepService.getAddress(user.get().getCEP());

        if(viaCepDTO.getLocalidade() == null || viaCepDTO.getUf() == null)
            throw new AddressNotFound(HttpStatus.NOT_FOUND, "Address Not Found", "The method to look up an address was called, but the address passed is invalid!");

        return new UsersDTO(user.get(), viaCepDTO);
    }

    public void save(Users user) throws InvalidFields, AddressNotFound {
        UsersValidation.validation(user);
        ViaCepDTO viaCepDTO = this.viaCepService.getAddress(user.getCEP());

        if(viaCepDTO.getLocalidade() == null || viaCepDTO.getUf() == null)
            throw new AddressNotFound(HttpStatus.NOT_FOUND, "Address Not Found", "The method to look up an address was called, but the address passed is invalid!");

        user.updateRA(UUID.randomUUID().toString());
        user.updateCreatedAt();
        user.updateUpdatedAt();

        this.usersRepository.save(user);
    }

    public void update(Users updatedUser, String ra) throws UserNotFound, InvalidFields, AddressNotFound {
        UsersValidation.validation(updatedUser);
        ViaCepDTO viaCepDTO = this.viaCepService.getAddress(updatedUser.getCEP());

        if(viaCepDTO.getLocalidade() == null || viaCepDTO.getUf() == null)
            throw new AddressNotFound(HttpStatus.NOT_FOUND, "Address Not Found", "The method to look up an address was called, but the address passed is invalid!");

        UsersDTO oldUser = this.findById(ra);
        Users oldUserDomain = new Users(oldUser.getRA(), oldUser.getName(), oldUser.getCep(), oldUser.getAddress().getNumber(), oldUser.getAddress().getComplement(), oldUser.getAdo(), oldUser.getPi(), oldUser.getCreatedAt(), oldUser.getUpdatedAt());

        this.modify(updatedUser, oldUserDomain);

        this.usersRepository.save(updatedUser);
    }

    public void delete(String ra) throws UserNotFound, AppErrors { /* checked */
        if(this.findById(ra) != null)
            this.usersRepository.deleteById(ra);
    }

    private void modify(Users updatedUser, Users oldUser) {
        updatedUser.updateRA(oldUser.getRA());
        updatedUser.updateCreatedAt(oldUser.getCreatedAt());
        updatedUser.updateUpdatedAt();
    }
}
