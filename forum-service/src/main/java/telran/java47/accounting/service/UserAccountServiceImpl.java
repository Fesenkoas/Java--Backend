package telran.java47.accounting.service;

import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import telran.java47.accounting.dao.UserAccountRepository;
import telran.java47.accounting.dto.RolesDto;
import telran.java47.accounting.dto.UserDto;
import telran.java47.accounting.dto.UserEditorDto;
import telran.java47.accounting.dto.UserRegesterDto;
import telran.java47.accounting.model.UserAccount;
import telran.java47.post.dto.UserExistsException;
import telran.java47.post.dto.UserNotFoundException;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

	final UserAccountRepository userAccountRepository;
	final ModelMapper modelMapper;

	@Override
	public UserDto register(UserRegesterDto userRegesterDto) {
		if (userAccountRepository.existsById(userRegesterDto.getLogin())) {
			throw new UserExistsException();
		}
		UserAccount userAccount = modelMapper.map(userRegesterDto, UserAccount.class);
		String password = BCrypt.hashpw(userRegesterDto.getPassword(), BCrypt.gensalt());
		userAccount.setPassword(password);
		userAccount.addRole("USER");
		userAccountRepository.save(userAccount);
		return modelMapper.map(userAccount, UserDto.class);
	}

	@Override
	public UserDto getUser(String login) {
		UserAccount userAccount = userAccountRepository.findById(login).orElseThrow(UserNotFoundException::new);
		return modelMapper.map(userAccount, UserDto.class);
	}

	@Override
	public UserDto deleteUser(String login) {
		UserAccount userAccount = userAccountRepository.findById(login).orElseThrow(UserNotFoundException::new);
		userAccountRepository.delete(userAccount);
		return modelMapper.map(userAccount, UserDto.class);
	}

	@Override
	public UserDto updateUser(String login, UserEditorDto userEditorDto) {
		UserAccount userAccount = userAccountRepository.findById(login).orElseThrow(UserNotFoundException::new);
		userAccount.setFirstName(userEditorDto.getFirstName());
		userAccount.setLastName(userEditorDto.getLastName());
		userAccountRepository.save(userAccount);
		return modelMapper.map(userAccount, UserDto.class);
	}

	@Override
	public RolesDto changeRolesList(String login, String role, Boolean isAddRole) {
		UserAccount userAccount = userAccountRepository.findById(login).orElseThrow(UserNotFoundException::new);
		if (isAddRole) 
			userAccount.addRole(role);
		else
			userAccount.removeRole(role);
		userAccountRepository.save(userAccount);
		return modelMapper.map(userAccount, RolesDto.class);
	}
	

	@Override
	public void changePassword(String login, String newPasword) {
//		UserAccount userAccount = userAccountRepository.findById(login).orElseThrow(UserNotFoundException::new);
//		String password = BCrypt.hashpw(newPasword, BCrypt.gensalt());
//		userAccount.setPassword(password);
//		userAccountRepository.save(userAccount);
	}

}
